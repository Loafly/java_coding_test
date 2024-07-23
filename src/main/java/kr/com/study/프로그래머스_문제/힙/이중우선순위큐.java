package kr.com.study.프로그래머스_문제.힙;

import java.util.Collections;
import java.util.PriorityQueue;

/*
    문제
        - 최대값/최소값 을 출력
        - operation
            - I 숫자 : 숫자를 큐에 삽입한다
            - D 1 : 큐에서 최대값을 삭제한다
            - D -1 : 큐에서 최소값을 삭제한다
    조건
        - 1 <= operations.length <= 1000000
        - 빈 큐에 대해서는 무시
        - 둘 이상인 경우 하나만 삭제한다
 */

public class 이중우선순위큐 {
    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
//        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
//        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};

        System.out.println(solution(operations)[0]);
        System.out.println(solution(operations)[1]);
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();

        for (String operation : operations) {
            int value = Integer.parseInt(operation.substring(2));

            // 값 추가
            if(operation.startsWith("I")) {
                maxPriorityQueue.add(value);
                minPriorityQueue.add(value);
            }
            // 삭제
            else if(operation.startsWith("D")) {
                //최대값 삭제
                if (value >= 0 && !maxPriorityQueue.isEmpty()) {
                    value = maxPriorityQueue.poll();
                    minPriorityQueue.remove(value);
                }
                // 최소값 삭제
                else if (value <= 0 && !minPriorityQueue.isEmpty()){
                    value = minPriorityQueue.poll();
                    maxPriorityQueue.remove(value);
                }
            }
        }

        if(minPriorityQueue.isEmpty()) {
            return new int[]{0,0};
        }
        if(maxPriorityQueue.isEmpty()) {
            return new int[]{0,0};
        }

        return new int[] {maxPriorityQueue.peek(), minPriorityQueue.peek()};
    }

}
