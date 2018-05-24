package com.jxs.list;

/**
 * Created by jiangxs on 2018/5/23.
 */
public class CycleLinkList<T> {

    private class Node {

        private Node next;
        private T elementData;

        public Node() {}

        public Node(T elementData, Node next) {

            this.next = next;
            this.elementData = elementData;
        }
    }

    private Node header;
    private Node tail;
    private int size;

    public CycleLinkList() {

        header = new Node();
        header.next = header;
        tail = header;
        tail.next = header;
        size = 0;
    }

    // 在头部节点后增加节点
    public void addHeader(T elementData) {

        Node temp = header.next;
        Node node = new Node(elementData, temp);
        header.next = node;
        size++;
    }

    // 在尾部节点处增加节点
    public void add(T elementData) {

        Node node = new Node(elementData, header);
        tail.next = node;
        node.next = header;
        tail = node;
        size++;
    }

    // 查找指定位置的节点
    public Node getNodeByIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("查找范围超出链表边界！");
        } else {
            Node current = header;
            for (int i = 0; i < size; i++) {
                current = current.next;
                if (current != null && index == i) {
                    return current;
                }
            }
        }
        return null;
    }

    // 在指定位置插入节点
    public void insert(int index, T elementData) {

        if (index == 0) {
            addHeader(elementData);
        } else if (index == size - 1) {
            add(elementData);
        } else if (index > 0 && index < size) {
            Node node = new Node(elementData, null);
            Node prev = getNodeByIndex(index - 1);
            node.next = prev.next;
            prev.next = node;
        }
        size++;
    }

    // 删除指定位置的节点
    public void delete(int index) {

        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("删除的位置超出链表范围！");
        }
        Node node = header;
        if (index == 0) {
            header.next = header.next.next;
        } else {
            for (int i = 0; i < size; i++) {
                node = node.next;
                if (index == i) {
                    Node prev = getNodeByIndex(index - 1);
                    prev.next = node.next;
                }
            }
        }
        size--;
    }

    @Override
    public String toString(){
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            sb.append(header.elementData + "->");
            for (Node current = header.next; current != header; current = current.next) {
                sb.append(current.elementData + "->");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }

    public static void main(String[] args) {

        CycleLinkList<String> cl = new CycleLinkList<>();
        cl.add("jxs");
        cl.add("xxx");
        cl.add("sss");
        cl.addHeader("jjj");
        cl.insert(2,"wrq");
        //cl.delete(0);
        System.out.println(cl);
        System.out.println(cl.getNodeByIndex(4).next.next.elementData);
    }
}
