package com.jxs.stackAndQueue;

public class SequenceQueue<T> {

    private static final int MAXSIZE = 16;
    private Object[] queue;
    private int front;
    private int rear;
    private int size;

    public SequenceQueue() {

        queue = new Object[MAXSIZE];
        size = 0;
        front = 0;
        rear = 0;
    }

    // 进队列操作
    public void enterQueue(T element) {

        if ((rear + 1) % MAXSIZE == front) {
            throw new IndexOutOfBoundsException("队列已满，无法再增加元素！");
        } else {
            queue[rear] = element;
            rear = (rear + 1) % MAXSIZE;
            size++;
        }
    }

    // 出队列操作
    public T detachQueue() {

        T elementData;
        if (front == rear) {
            throw new NullPointerException("队列为空，无法再对队列进行移除操作！");
        } else {
            elementData = (T) queue[front];
            front = (front + 1) % MAXSIZE;
            size--;
        }
        return elementData;
    }

    @Override
    public String toString() {

        if (queue == null) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = front; i < rear; i++) {
                sb.append(queue[i] + " ");
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }
    }

    public static void main(String[] args) {

        SequenceQueue<String> sq = new SequenceQueue<>();
        sq.enterQueue("jjj");
        sq.enterQueue("xxx");
        sq.enterQueue("sss");
        sq.enterQueue("jxs");
        sq.enterQueue("jjj");
        sq.enterQueue("xxx");
        sq.enterQueue("sss");
        sq.enterQueue("jxs");
        sq.enterQueue("jjj");
        sq.enterQueue("xxx");
        sq.enterQueue("sss");
        sq.enterQueue("jxs");
        sq.enterQueue("jjj");
        sq.enterQueue("xxx");
        sq.enterQueue("sss");
        sq.detachQueue();
        sq.detachQueue();
        sq.enterQueue("hhhhh");
        sq.enterQueue("wwwww");
        System.out.println(sq);
    }
}
