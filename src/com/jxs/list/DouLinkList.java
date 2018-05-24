package com.jxs.list;

public class DouLinkList<T> {

    private class Node {

        private Node next;
        private Node prev;
        private T elementData;

        public Node() {}

        public Node(T elementData, Node prev, Node next) {

            this.elementData = elementData;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node header;
    private Node tail;
    private int size;

    public DouLinkList() {

        header = new Node();
        header = header.next;
        header = header.prev;
        tail = header;
        size = 0;
    }

    public void add(T elementData) {

        Node node = new Node(elementData, tail, header);
        tail = node;
        size++;
    }

    @Override
    public String toString(){
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = header; current != null; current = current.next)
                sb.append(current.elementData + "->").toString();
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }

    public static void main(String[] args) {

        DouLinkList<String> dl = new DouLinkList<>();
        dl.add("jxs");
        dl.add("xxx");
        dl.add("sss");
        System.out.println(dl);
    }
}
