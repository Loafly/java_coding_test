package kr.com.study.문법;

public class 문자열비교 {
    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = "Hello";
        String str3 = "World";

        // 문자열 시작이 같은지 비교
        System.out.println(str1.startsWith(str2));  // true

        // 문자열 마지막이 같은지 비교
        System.out.println(str1.endsWith(str3));    // true
    }

}
