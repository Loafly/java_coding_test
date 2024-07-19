package kr.com.study.프로그래머스_문제.완전탐색;

/*
  1. sizes의 길이는 1 이상 10,000 이하
  2. sizes의 원소는 [w, h] 형식
    - w : 가로 길이
    - h : 세로 길이
   3. w와 h는 1 이상 1,000 이하인 자연수
 */


public class 최소직사각형 {
  public int solution(int[][] sizes) {
    int answer = 0;

    int maxW = 0;
    int maxH = 0;

    for (int[] size : sizes) {
      maxW = Math.max(maxW,  Math.max(size[0], size[1]));
      maxH = Math.max(maxH, Math.min(size[0], size[1]));
    }

    answer = maxW * maxH;

    String a = "";

    return answer;
  }
}
