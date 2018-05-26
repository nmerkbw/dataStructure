package com.jxs.stackAndQueue;

public class CycleSequenceQueue<T> {

    private static final int MAXSIZE = 16;
    private Object[] queue;
    private int front;
    private int rear;
    private int size;

    public CycleSequenceQueue() {

        queue = new Object[MAXSIZE];
        size = 0;
        front = 0;
        rear = 0;
    }

    // 进队列操作
    public void enterQueue(T element) {

        if (rear == front && queue[front] != null) {
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
        if (front == rear && queue[front] == null) {
            throw new NullPointerException("队列为空，无法再对队列进行移除操作！");
        } else {
            elementData = (T) queue[front];
            queue[front] = null;
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
            if (rear > front) {
                for (int i = front; i < rear; i++) {
                    sb.append(queue[i] + " ");
                }
            } else if (rear <= front) {
                for (int i = front; i < MAXSIZE; i++) {
                    sb.append(queue[i] + " ");
                }
                for (int i = 0; i < rear; i++) {
                    sb.append(queue[i] + " ");
                }
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }
    }

    public static void main(String[] args) {

        CycleSequenceQueue<String> sq = new CycleSequenceQueue<>();
        sq.enterQueue("1");
        sq.enterQueue("2");
        sq.enterQueue("3");
        sq.enterQueue("4");
        sq.enterQueue("5");
        sq.enterQueue("6");
        sq.enterQueue("7");
        sq.enterQueue("8");
        sq.enterQueue("9");
        sq.enterQueue("10");
        sq.enterQueue("11");
        sq.enterQueue("12");
        sq.enterQueue("13");
        sq.enterQueue("14");
        sq.enterQueue("15");
        sq.enterQueue("16");
        sq.detachQueue();
        sq.detachQueue();
        sq.enterQueue("17");
        sq.enterQueue("18");
        sq.detachQueue();
        System.out.println(sq);
    }
}
