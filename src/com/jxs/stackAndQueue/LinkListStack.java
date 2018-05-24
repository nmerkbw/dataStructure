package com.jxs.stackAndQueue;


public class LinkListStack<T> {

    private class Node {

        private Node next;
        private T element;

        public Node() {}

        public Node(T element, Node next) {

            this.element = element;
            this.next = next;
        }
    }

    private Node top;
    private int size;

    public LinkListStack() {

        top = new Node();
        size = 0;
    }

    // 进栈操作
    public void push(T element) {

        Node node = new Node(element, top);
        top = node;
        size++;
    }

    // 出栈操作
    public Node pop() {

        Node node;
        if (size < 0) {
            throw new IndexOutOfBoundsException("栈为空，无法进行弹出！");
        } else {
            node = top.next;
            top = node;
            size--;
        }
        return node;
    }

    @Override
    public String toString() {

        if (top == null) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = top; current.next != null; current = current.next) {
                sb.append(current.element + ",");
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }
    }

    public static void main(String[] args) {

        LinkListStack<String> stack = new LinkListStack<>();
        stack.push("sss");
        stack.push("xxx");
        stack.push("jjj");
        stack.push("jxs");
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }
}
