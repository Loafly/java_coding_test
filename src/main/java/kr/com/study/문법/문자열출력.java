package kr.com.study.문법;

public class 문자열출력 {

  public static void main(String[] args) {
    String str = "출력할 문자열";
    int a = 0;
    int b = 2;

    // 1. 기본 출력
    System.out.println("출력 :" + str + (a + b));

    // 2. print 포멧을 사용하여 출력
    System.out.printf("출력 : %s %d \n", str, a +  b);

    // 3. String 포멧을 사용하여 출력
    System.out.println(String.format("출력 : %s %d \n", str, a + b));
  }

}
