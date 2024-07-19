package kr.com.study.문법;

public class 자료형변환 {

  public static void main(String[] args) {
    String str = "1111";
    int integer = 10;
    char ch1 = '9';

    // 문자열 to Integer
    System.out.println(Integer.parseInt(str));

    // 문자열 to Long
    System.out.println(Long.parseLong(str));

    // Integer to 문자열
    System.out.println(String.valueOf(integer));

    // Char to int
    System.out.println(ch1 - '0');
    System.out.println(Character.getNumericValue(ch1));

  }

}
