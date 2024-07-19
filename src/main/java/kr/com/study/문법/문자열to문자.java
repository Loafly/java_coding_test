package kr.com.study.문법;

public class 문자열to문자 {

  public static void main(String[] args) {
    String str = "AaBbCcDd";

    // 1. toCharArray 사용
    for(char a : str.toCharArray()) {
      System.out.println(a);
    }

    // 2. CharAt 사용
    for (int i = 0; i < str.length(); i++) {
      System.out.println(str.charAt(i));
    }
  }

}
