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

    // 判断栈是否为空
    public boolean isEmpty() {

        if (size == 0) {
            return true;
        }
        return false;
    }

    // 进栈操作
    public void push(T element) {

        Node node = new Node(element, top);
        top = node;
        size++;
    }

    // 出栈操作
    public T pop() {

        Node node;
        if (size < 0) {
            throw new IndexOutOfBoundsException("栈为空，无法进行弹出！");
        } else {
            node = top;
            top = top.next;
            node.next = null;
            size--;
        }
        return node.element;
    }

    public T peek() {

        if (size < 0) {
            return null;
        }
        return top.element;
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
