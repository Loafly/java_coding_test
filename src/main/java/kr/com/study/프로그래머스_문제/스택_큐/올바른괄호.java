package kr.com.study.프로그래머스_문제.스택_큐;

import java.util.Stack;

/*
    문제
        - 문자열의 괄호가 정상적으로 열리고 닫히고 있는지 true, false 출력
    조건
        - 문자열(s).length <= 100,000
        - 문자열(s)는 '(' 또는 ')'로만 작성
 */

public class 올바른괄호 {

    public static void main(String[] args) {

        String str = "(())";
        System.out.println(solution(str));

    }

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
