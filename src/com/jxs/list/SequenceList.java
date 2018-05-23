package com.jxs.list;

public class SequenceList<T> {

    // 存储空间默认容量
    public static final int DEFAULT = 16;
    // 线性表当前最大容量
    private int capacity;
    // 线性表中元素个数
    private int size;
    private Object[] elementData;

    // 默认长度创建线性表
    public SequenceList() {

        elementData = new Object[DEFAULT];
        capacity = DEFAULT;
    }

    // 指定长度创建线性表
    public SequenceList(int initSize) {

        capacity = 1;
        // 一直将线性表容量扩展到到大于初始容量为止
        while (initSize > capacity) {
            capacity = capacity << 1;
        }
        elementData = new Object[capacity];
    }

    public void add(T element) {

        insert(element, size);
    }

    public T delete(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("要删除的元素位置不存在！");
        }
        T old = (T) elementData[index];
        int movLength = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, movLength);
        size--;
        return old;
    }

    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("获取元素的位置不存在！");
        }
        return (T) elementData[index];
    }

    public void insert(T element, int index) {

        if (index < 0 || index > size) {
            throw new RuntimeException("插入的位置超过了线性表的边界");
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    @Override
    public String toString() {

        if (elementData == null) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append(elementData[i] + ",");
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }
    }

    public static void main(String[] args) {

        SequenceList<String> sl = new SequenceList<>();
        sl.add("jxs");
        sl.add("jjj");
        sl.add("xxx");
        sl.add("sss");
        sl.delete(0);
        System.out.println(sl);
    }
}
