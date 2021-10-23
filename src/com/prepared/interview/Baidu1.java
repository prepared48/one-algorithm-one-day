package com.prepared.interview;

public class Baidu1 {

    public static void main(String[] args) {
        Node node1 = new Node(5, null);
        Node node2 = new Node(4, node1);
        Node node3 = new Node(3, node2);
        Node node4 = new Node(2, node3);
        Node head = new Node(1, node4);

        Baidu1 baidu1 = new Baidu1();
        Node newHead = baidu1.reverseLink(head);
        System.out.println(newHead);
    }


    public Node reverseLink(Node head) {

        Node virtual = new Node(null, head);
        boolean flag = true;
        while (head != null) {
            Node temp = head.next;
            head.next = virtual;
            if(flag) {
                virtual.next = null;
                flag = false;
            }
            virtual = head;
            head = temp;
        }
        return virtual;
    }


    static class Node {

        private Integer val;

        private Node next;

        public Node(Integer val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
