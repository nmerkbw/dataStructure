package com.jxs.list;

public class LinkList<T> {

    private class Node {

        private T elementData;
        private Node next;

        public Node() {
        }

        public Node(T elementData) {

            this.elementData = elementData;
        }

        public Node(T elementData, Node next) {

            this.elementData = elementData;
            this.next = next;
        }
    }

    private Node header;
    private Node tail;
    private int size;

    public LinkList() {

        header = new Node();
        tail = header;
        size = 0;
    }

    // 获取指定位置的节点
    public Node getNodeByIndex(int index) {

        Node current = header;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("要查找的节点位置超出了线性表的边界！");
        }
        for (int i = 0; i < size; i++) {
            current = current.next;
            if (current != null && i == index) {
                return current;
            }
        }
        return null;
    }

    // 在链表尾部增加节点
    public void add(T element) {

        // 创建新节点
        Node node = new Node(element, null);
        tail.next = node;
        tail = node;
        size++;
    }

    // 在链表头部增加节点（节点放置在头结点之后）
    public void addHeader(T element) {

        Node temp = header.next;
        Node node = new Node(element, temp);
        header.next = node;
        size++;
    }

    // 在指定的地方插入节点
    public void insert(int index, T element) {

        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("要插入的位置超过线性表的边界！");
        }
        Node prev = getNodeByIndex(index - 1);
        Node next = getNodeByIndex(index);
        Node node = new Node(element, null);
        node.next = next;
        prev.next = node;
        size++;
    }

    // 删除指定位置上的节点
    public void delete(int index) {

        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("要删除的节点位置超过了线性表的边界！");
        }
        Node next = getNodeByIndex(index + 1);
        if (index == 0) {
            header.next = next;
        } else {
            Node prev = getNodeByIndex(index - 1);
            prev.next = next;
        }
        size--;
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

        LinkList<String> ll = new LinkList<>();
        ll.add("jxs");
        ll.add("xxx");
        ll.add("sss");
        ll.addHeader("jjj");
        ll.addHeader("hahaha");
        ll.delete(0);
        ll.insert(2,"wrq");
        System.out.println(ll);
        System.out.println(ll.getNodeByIndex(0).elementData);
    }
}
