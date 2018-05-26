package com.jxs.stackAndQueue;

/**
 * Created by jiangxs on 2018/5/26.
 *
 * 队列的链式结构
 */
public class LinkListQueue<T> {

    private class Node {

        private T elementData;
        private Node next;

        public Node() {
        }

        public Node(T elementData, Node next) {

            this.elementData = elementData;
            this.next = next;
        }
    }

    private Node header;
    private Node tail;
    private int size;

    public LinkListQueue() {

        header = new Node();
        tail = header;
        size = 0;
    }

    // 进队列
    public void enterQueue(T element) {

        Node node = new Node(element, null);
        tail.next = node;
        tail = node;
        size++;
    }

    // 出队列
    public T detachQueue() {

        if (size < 0) {
            throw new IndexOutOfBoundsException("队列为空，无元素出队列！");
        }
        Node node = header.next;
        header.next = node.next;
        size--;
        return node.elementData;
    }

    @Override
    public String toString() {

        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = header.next; current != null; current = current.next) {
                sb.append(current.elementData + ",");
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }
    }

    public static void main(String[] args) {

        LinkListQueue lq = new LinkListQueue();
        lq.enterQueue("1");
        lq.enterQueue("2");
        lq.enterQueue("3");
        lq.enterQueue("4");
        lq.detachQueue();
        lq.detachQueue();
        System.out.println(lq);
    }
}
