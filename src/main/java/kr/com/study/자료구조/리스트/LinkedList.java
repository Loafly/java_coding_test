package kr.com.study.자료구조.리스트;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    public static class Node {
        private Node nextNode;
        private Object data;

        public Node(Node nextNode, Object data) {
            this.nextNode = nextNode;
            this.data = data;
        }
    }

    public int size() {
        return this.size;
    }

    public void addFirst(Object data) {
        if(head == null) {
            add(data);
        }

        head = new Node(head, data);
        size++;
    }

    public void addLast(Object data) {
        add(data);
    }

    public boolean add(Object data) {
        if(head == null) {
            head = new Node(null, data);
            tail = head;
        } else if (head == tail) {
            tail = new Node(null, data);
            head.nextNode = tail;
        }
        else {
            tail.nextNode = new Node(null, data);
            tail = tail.nextNode;
        }
        size++;
        return true;
    }

    public Object getFirst() {
        if(head == null) {
            return null;
        }

        return head.data;
    }

    public Object getLast() {
        if(tail == null) {
            return null;
        }
        return tail.data;
    }

    public Object removeFirst() {
        if(head == null) {
            return null;
        }

        Node currentHeadNode = head;
        head = currentHeadNode.nextNode;

        size --;
        return currentHeadNode.data;
    }

    public Object removeLast() {
        if (head == null) {
            return null;
        }

        if(head == tail) {
            Object data = head.data;
            clear();
            return data;
        }

        Node currentNode = head;
        Node tailNode = tail;
        while (currentNode.nextNode != tail) {
            currentNode = currentNode.nextNode;
        }

        currentNode.nextNode = null;
        tail = currentNode;
        size--;

        return tailNode.data;
    }

    public Object remove(Object object) {
        if(head == null) {
            return null;
        }

        Node prevNode = null;
        Node currentNode = head;

        while(currentNode != null) {
            Object data = currentNode.data;
            Node nextNode = currentNode.nextNode;
            if(object.equals(data)) {
                if(prevNode == null) {
                    head = nextNode;
                } else {
                    prevNode.nextNode = nextNode;
                }
                size --;
                return currentNode.data;
            }

            prevNode = currentNode;
            currentNode = nextNode;
        }

        return null;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(Object o) {
        if(head == null) {
            return false;
        }

        Node currentNode = head;
        while(currentNode != null) {
            if(currentNode.data.equals(o)) {
                return true;
            }
            currentNode = currentNode.nextNode;
        }

        return false;
    }

    public Object get(int index) {
        if(head == null) {
            return null;
        }

        if(size <= index) {
            return null;
        }

        Node currentNode = head;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.nextNode;
        }

        return currentNode.data;
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);

        System.out.println("값은 : " + linkedList.remove(1));
        System.out.println("size : " + linkedList.size());
        System.out.println("값은 : " + linkedList.removeFirst());
        System.out.println("size : " + linkedList.size());


        linkedList.add(3);
        linkedList.add(4);
        System.out.println("클리어 전 size : " + linkedList.size());
        linkedList.clear();
        System.out.println("클리어 후 size : " + linkedList.size());

        linkedList.add(55);
        linkedList.add(66);
        linkedList.add(13);
        System.out.println("요소 포함 여부 (true) : " + linkedList.contains(55));
        System.out.println("요소 포함 여부 (false) : " + linkedList.contains(6));
        System.out.println("처음 요소 찾기 : 55 : " + linkedList.getFirst());
        System.out.println("마지막 요소 찾기 : 13 : " + linkedList.getLast());
        System.out.println("마지막 요소 삭제 : 13 : " + linkedList.removeLast());
        System.out.println("마지막 요소 삭제 : 66 : " + linkedList.removeLast());

        linkedList.addFirst(500);
        System.out.println("맨 처음 요소 추가 500 : " + linkedList.getFirst());
        linkedList.addLast(800);
        System.out.println("맨 마지막 요소 추가 800 : " + linkedList.getLast());

        System.out.println("0번째 인덱스 500 : " + linkedList.get(0));
        System.out.println("size : " + linkedList.size());
        System.out.println("마지막 인덱스 800 : " + linkedList.get(2));
    }
}

