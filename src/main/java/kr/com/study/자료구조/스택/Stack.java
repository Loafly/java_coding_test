package kr.com.study.자료구조.스택;

public class Stack<T> {
    private int size = 0;
    private Node top = null;

    private class Node {
        private final Node prevNode;
        private final T data;

        public Node(Node prevNode, T data) {
            this.prevNode = prevNode;
            this.data = data;
        }
    }

    public T push(T data) {
        top = new Node(top, data);
        size++;
        return top.data;
    }

    public T pop() {
        if(top == null) {
            throw new IndexOutOfBoundsException("스택이 비어있습니다.");
        }

        Node topNode = top;
        top = top.prevNode;
        size--;
        return topNode.data;
    }

    public T peek() {
        if(top == null) {
            throw new IndexOutOfBoundsException("스택이 비어있습니다.");
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();

        System.out.println("1 추가 : " + integerStack.push(1));
        System.out.println("2 추가 : " + integerStack.push(2));

        System.out.println("맨 위 조회 : " + integerStack.peek());
        System.out.println("맨 위 제거 : " + integerStack.pop());
        System.out.println("맨 위 조회 : " + integerStack.peek());
        System.out.println("맨 위 제거 : " + integerStack.pop());

        System.out.println("1 추가 : " + integerStack.push(1));
        System.out.println("2 추가 : " + integerStack.push(2));
        System.out.println("클리어 이전 사이즈 : " + integerStack.size());
        System.out.println("클리어 이전 empty 여부 : " + integerStack.isEmpty());
        integerStack.clear();
        System.out.println("클리어 이후 사이즈 : " + integerStack.size());
        System.out.println("클리어 이후 empty 여부 : " + integerStack.isEmpty());

    }
}
