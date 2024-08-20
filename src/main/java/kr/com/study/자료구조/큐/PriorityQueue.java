package kr.com.study.자료구조.큐;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T extends Comparable<T>> {

    private List<T> heap = new ArrayList<>();

    public void add(T item) {
        // 맨 마지막에 item 삽입
        heap.add(item);
        heapIfyUp(heap.size() - 1);
    }

    public T poll() {
        T firstItem = heap.getFirst();
        T lastItem = heap.removeLast();

        if(!heap.isEmpty()) {
            int firstIndex = 0;
            heap.set(firstIndex, lastItem);
            heapIfyDown(firstIndex);
        }

        return firstItem;
    }

    public T peek() {
        return heap.getFirst();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    // 위로 올라오면서 정리
    private void heapIfyUp(int index) {
        T item = heap.get(index);
        int parentIndex = (index - 1) / 2;

        // 아이템이 부모의 값 보다 작은 경우
        while(item.compareTo(heap.get(parentIndex)) < 0) {
            if(parentIndex == index) {
                break;
            }
            heap.set(index, heap.get(parentIndex));
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
        heap.set(index, item);
    }

    // 아래로 내려가면서 정리
    private void heapIfyDown(int index) {
        T item = heap.get(index);

        while (index < heap.size()) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestChildIndex = index;

            // 왼쪽 자식노드의 값이 있으며, 해당 값이 최솟값인 경우
            if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestChildIndex)) < 0) {
                smallestChildIndex = leftChildIndex;
            }

            // 오른쪽 자식노드의 값이 있으며, 해당 값이 최솟값인 경우
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestChildIndex)) < 0) {
                smallestChildIndex = rightChildIndex;
            }

            // 자식들중에 자기보다 작은 값이 없는 경우
            if (smallestChildIndex == index) {
                break;
            }

            heap.set(index, heap.get(smallestChildIndex));
            index = smallestChildIndex;
        }
        heap.set(index, item);
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3);
        pq.add(5);
        pq.add(1);
        pq.add(2);

        pq.poll();
        pq.poll();

        System.out.println(pq.peek());
    }
}
