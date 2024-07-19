package kr.com.study.문법;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 문자열배열붙이기 {

  public static void main(String[] args) {
    String[] str = {"a","b","c","d"};

    //1. String.join 사용
    System.out.println(String.join("", str));

    //2. Arrays 사용
    System.out.println(Arrays.stream(str).collect(Collectors.joining()));
  }

}
