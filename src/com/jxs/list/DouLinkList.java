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
        header.next = header;
        header.prev = header;
        tail = header;
        size = 0;
    }

    // 在链表尾部增加节点
    public void add(T elementData) {

        Node node = new Node(elementData, tail, null);
        tail.next = node;
        tail = node;
        size++;
    }

    // 在链表头部增加节点
    public void addHeader(T elementData) {

        Node node = new Node(elementData, header, null);
        node.next = header.next;
        header.next.prev = node;
        header.next = node;
        size++;
    }

    // 在指定位置插入节点
    public void insert(int index, T elementData) {

        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("插入的位置超出边界！");
        } else if (index == 0) {
            addHeader(elementData);
        } else if (index == size - 1) {
            add(elementData);
        } else if (index > 0 && index < size - 1) {
            Node prev = getNodeByIndex(index - 1);
            Node node = new Node(elementData, prev, null);
            node.next = prev.next;
            prev.next.prev = node;
            prev.next = node;
        }
        size++;
    }

    // 删除任意位置的节点
    public void delete(int index) {

        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("删除的节点位置超出了链表的范围！");
        } else if (index == 0) {
            header.next = header.next.next;
            header.next.next.prev = header;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else if (index > 0 && index < size - 1) {
            Node node = getNodeByIndex(index);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    // 获取链表中任意位置的节点
    public Node getNodeByIndex(int index) {

        Node current = header;
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("获取节点的位置超出了链表的边界");
        } else {
            for (int i = 0; i < size; i++) {
                current = current.next;
                if (current != null && i == index) {
                    return current;
                }
            }
        }
        return current;
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
        dl.addHeader("jjj");
        dl.insert(3, "wrq");
        dl.delete(3);
        System.out.println(dl);
        System.out.println(dl.getNodeByIndex(0).elementData);
    }
}
