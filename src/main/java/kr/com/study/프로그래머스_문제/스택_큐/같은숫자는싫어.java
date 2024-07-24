package kr.com.study.프로그래머스_문제.스택_큐;

/*
    문제
        - 연속으로 중복된 숫자가 있는 경우 제외 하고 출력한다.
    조건
        - 1 <= arr.size() <= 1,000,000
        - 0 <= 원소의 크기 <= 9
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class 같은숫자는싫어 {

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,3,3,0,1,1};

        int[] results = solution(arr);

        for (int result : results) {
            System.out.println(result);
        }

    }

    public static int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> results = new LinkedList<>();
        for (int i : arr) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            Integer value = queue.poll();

            if(results.isEmpty()) {
                results.add(value);
                continue;
            }

            Integer last = results.get(results.size() - 1);
            if(!Objects.equals(value, last)) {
                results.add(value);
            }
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

}
