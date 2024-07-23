package kr.com.study.프로그래머스_문제.힙;

/*
문제
- 가장 맵지 않은 음식 + (2번째로 맵지 않은 음식 *2) = 새로운 음식
- 위 공식 으로 음식을 섞어 새로운 음식을 만들어 모든 음식의 스코빌이 K이상이 나올 수 있는 횟수

조건
- 2 <= scoville.size <= 1,000,000
- 0 <= K <= 1,000,000,000
- scoville의 원소는 0 이상 1,000,000 이하
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 더_맵게 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution(scoville, k));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                Arrays.stream(scoville).boxed().collect(Collectors.toList())
        );

        while(priorityQueue.size() > 1) {
            int firstScoville = priorityQueue.poll();
            int secondScoville = priorityQueue.poll();

            if(firstScoville >= K) {
                return answer;
            }

            int newScoville = firstScoville + (secondScoville * 2);
            priorityQueue.add(newScoville);
            answer++;
        }

        if(priorityQueue.size() == 1 && priorityQueue.peek() >= K) {
            return answer;
        }

        return -1;
    }
}
