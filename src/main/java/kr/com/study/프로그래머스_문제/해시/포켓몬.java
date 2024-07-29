package kr.com.study.프로그래머스_문제.해시;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
    문제
        - 총 N 마리의 포켓몬 중 N/2 마리를 가져가는 경우 가장 많은 종류의 포켓몬을 선택하는 방법
        - 가장 많은 종류의 포켓몬의 종류 번호의 개수를 리턴
    조건
        - nums 는 1차원 배열
        - 1 <= nums.size() <= 10,000
        - 1 <= num <= 200,000

 */

public class 포켓몬 {

  public static void main(String[] args) {
    int[] nums = new int[]{3,1,2,3};
    System.out.println(solution(nums));
  }

  public static int solution(int[] nums) {
    return Math.min(Arrays.stream(nums).boxed().collect(Collectors.toSet()).size(), nums.length / 2);
  }

}
