package kr.com.study.프로그래머스_문제.스택_큐;

/*
    문제
        - 배포 시점마다 몇개의 기능이 배포되는지 출력
    조건
        - 작업 개수 (progresses, speeds 배열의 길이)는 100개 이하
        - 작업 진도 < 100
        - 작업 속도 < 100

 */

import java.util.*;

public class 기능개발 {

    public static void main(String[] args) {

        int[] progresses = new int[]{93, 55, 30};
        int[] speeds = new int[]{1, 5, 30};

        System.out.println(solution(progresses, speeds)[0]);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> daysQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remainingWork = 100 - progresses[i];
            int dailyWork = speeds[i];

            int days = (int) Math.ceil((double) remainingWork / dailyWork);

            daysQueue.add(days);
        }


        while (!daysQueue.isEmpty()) {
            int deployDay = daysQueue.poll();
            int count = 1;

            while (!daysQueue.isEmpty() && daysQueue.peek() <= deployDay) {
                daysQueue.poll();
                count++;
            }

            result.add(count);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

}
