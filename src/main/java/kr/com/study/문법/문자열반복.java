package kr.com.study.문법;

public class 문자열반복 {

  public static void main(String[] args) {
    String str = "반복호출";

    int n = 5;

    // 1. repeat 함수 호출 -> java 11 부터 추가
    System.out.println(str.repeat(n));

    // 2. for 문 활용
    for (int i = 0; i < n; i++) {
      System.out.print(str);
    }

  }

}
