package kr.com.study.프로그래머스_문제.힙;


/*
    문제
        - 하드디스크는 한번에 하나의 작업만 수행 가능하다.
        - 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법의 평균 시간을 return
    조건
        - 1 <= jobs.size() <= 500
        - jobs[i, j]
            - i : 요청되는 시점   ( 0 <= i <= 1000)
            - j : 작업의 소요 시간 ( 1 <= j <= 1000)

 */

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {{0,3}, {1,9}, {2,6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        return answer;
    }
}
