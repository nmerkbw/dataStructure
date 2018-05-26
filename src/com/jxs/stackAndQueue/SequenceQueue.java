package com.jxs.stackAndQueue;

/**
 * Created by jiangxs on 2018/5/26.
 *
 * 队列的顺序存储结构
 */
public class SequenceQueue<T> {

    public static final int MAXSIZE = 16;
    private Object[] queue;
    private int front;
    private int rear;
    private int size;

    public SequenceQueue() {

        queue = new Object[MAXSIZE];
        front = 0;
        rear = 0;
        size = 0;
    }

    // 进队列
    public void enterQueue(T elementData) {

        if (rear >= MAXSIZE) {
            throw new IndexOutOfBoundsException("队列已满，无法再添加元素！");
        } else {
            queue[rear++] = elementData;
            size++;
        }
    }

    // 出队列
    public T detachQueue() {

        T element;
        if (size < 0) {
            throw new IndexOutOfBoundsException("队列为空，无法再出队列中的元素！");
        } else {
            element = (T) queue[front++];
            size--;
        }
        return element;
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
        sq.enterQueue("1");
        sq.enterQueue("2");
        sq.enterQueue("3");
        sq.detachQueue();
        System.out.println(sq);
    }
}
