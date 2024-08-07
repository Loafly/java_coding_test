package kr.com.study.자료구조.이진탐색;

public class BinarySearchTree {

    private class Node {
        private int key;
        private Node leftNode;
        private Node rightNode;

        public Node(int key, Node leftNode, Node rightNode) {
            this.key = key;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    private Node root;

    public void insert(int key) {
        if(root == null) {
            root = new Node(key, null, null);
            return;
        }
        insertRecursively(key, root);
    }

    private void insertRecursively(int key, Node parent) {
        // 상위 노드보다 큰 경우
        if(parent.key < key) {
            if(parent.rightNode == null) {
                parent.rightNode = new Node(key, null, null);
                return;
            }

            insertRecursively(key, parent.rightNode);
        }

        // 상위 노드보다 작은 경우
        if(parent.key > key) {
            if(parent.leftNode == null) {
                parent.leftNode = new Node(key, null, null);
                return;
            }

            insertRecursively(key, parent.leftNode);
        }
    }

    public void delete(int key) {
        System.out.printf("-----%d 삭제----- %n", key);
        root = deleteRecursively(key, root);
    }

    private Node deleteRecursively(int key, Node parent) {
        if(parent == null) {
            return null;
        }

        // 상위 노드가 더 큰 경우
        if(parent.key > key) {
            parent.leftNode = deleteRecursively(key, parent.leftNode);
        }
        // 상위 노드가 더 작은 경우
        else if (parent.key < key) {
            parent.rightNode = deleteRecursively(key, parent.rightNode);
        }
        // 상위 노드가 삭제할 데이터인 경우
        else {
            // 왼쪽 노드가 없는 경우, 오른쪽 노드를 기존 삭제된 노드로 대체
            if(parent.leftNode == null) {
                return parent.rightNode;
            }
            // 오른쪽 노드가 없는 경우, 왼쪽 노드를 기존 삭제된 노드로 대체
            else if (parent.rightNode == null) {
                return parent.leftNode;
            }

            // 자식노드가 존재하는 경우 오른쪽 노드를 기준으로 재배치
            // - 오른쪽 노드의 가장 작은값을 상위 노드 값으로 변경
            // - 오른쪽 노드에서 가장 작은값 제거

            parent.key = minValueNode(parent.rightNode).key;
            parent.rightNode = deleteRecursively(parent.key, parent.rightNode);

        }

        return parent;
    }

    // minValueNode 함수
    private Node minValueNode(Node root) {
        Node currentNode = root;
        while (currentNode.leftNode != null) {
            currentNode = currentNode.leftNode;
        }
        return currentNode;
    }

    public Node search(int key) {
        return searchRecursively(key, root);
    }

    private Node searchRecursively(int key, Node parent) {
        if(parent == null) {
            return null;
        }

        // 상위 노드보다 큰 값인 경우
        if(parent.key < key) {
            return searchRecursively(key, parent.rightNode);
        }

        // 상위 노드보다 큰 값인 경우
        if(parent.key > key) {
            return searchRecursively(key, parent.leftNode);
        }

        // 상위 노드와 동일한 값인 경우
        return parent;
    }

    public void inorderTraversal() {
        System.out.println("-----중위 순회 시작-----");
        inorderTraversalRecursively(root);
        System.out.println("-----중위 순회 종료-----");
    }

    public void inorderTraversalRecursively(Node parent) {
        if(parent.leftNode != null) {
            inorderTraversalRecursively(parent.leftNode);
        }

        System.out.println(parent.key);

        if(parent.rightNode != null) {
            inorderTraversalRecursively(parent.rightNode);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(50);
        binarySearchTree.insert(15);
        binarySearchTree.insert(62);
        binarySearchTree.insert(80);
        binarySearchTree.insert(7);
        binarySearchTree.insert(54);
        binarySearchTree.insert(11);

        binarySearchTree.inorderTraversal();

        binarySearchTree.delete(7);
        binarySearchTree.inorderTraversal();
        binarySearchTree.delete(62);
        binarySearchTree.inorderTraversal();

    }


}


