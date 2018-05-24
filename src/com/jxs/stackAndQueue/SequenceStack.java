package com.jxs.stackAndQueue;

public class SequenceStack<T> {

    // 存储空间的默认尺寸
    public static final int DEFAULT = 16;
    private Object[] stack;
    // 栈顶元素所在位置
    private int top;

    public SequenceStack() {

        stack = new Object[DEFAULT];
        top = -1;
    }

    // 进栈操作
    public void push(T element) {

        if (top == DEFAULT - 1) {
            throw new IndexOutOfBoundsException("入栈超过了栈的容量！");
        } else {
            stack[++top] = element;
        }
    }

    // 出栈操作
    public T pop() {

        T element;
        if (top == -1) {
            throw new NullPointerException("栈为空，无法进行弹栈操作！");
        } else {
            element = (T) stack[--top];
        }
        return element;
    }

    @Override
    public String toString() {

        if (stack == null) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = top; i > -1; i--) {
                sb.append(stack[i] + ",");
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }
    }

    public static void main(String[] args) {

        SequenceStack<String> stack = new SequenceStack();
        stack.push("jxs");
        stack.push("sss");
        stack.push("xxx");
        stack.push("jjj");
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }
}
