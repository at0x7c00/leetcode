package me.huqiao.algorithms.queue;

import java.util.*;

/**
 * 环形数组队列
 * 内部基于数组实现，当前空间不足时可以动态增长
 */
public class CircleArrayQueue<T> {
    final static int DEFAULT_SIZE = 10;
    private Object[] elements;
    private int front; //队列头
    private int rear;  //队列尾
    private int size;  //有效数据数量
    private int arraySize;

    public CircleArrayQueue(){
        elements = new Object[DEFAULT_SIZE];
        arraySize = elements.length;
        List x = new ArrayList();
    }

    public CircleArrayQueue(int initSize){
        if(initSize<=0){
            throw new IllegalArgumentException("Illegal init size:" + initSize);
        }
        elements = new Object[initSize];
        arraySize = elements.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size >= arraySize;
    }

    public int size(){
        return size;
    }

    public void enqueue(T t){
        if(isFull()){
            growUp();
        }
        elements[rear] = t;
        rear++;
        rear = rear % arraySize; //取模预算，可以将递增的变量限制在一个范围以内
        size++;
    }

     public T dequeue(){
        if(isEmpty()){
            return null;
        }
        T t = (T)elements[front];
        size--;
        front++;
        front = front % arraySize;
        return t;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        T[] array = toArray();
        for(T t : array) {
            sb.append(t.toString()).append(",");
        }
        return sb.toString();
    }

    /**
     * 以队列的顺序（而不是数组的原始顺序）输出
     * @return
     */
    public T[] toArray(){
        int count = size;
        T[] res = (T[])new Object[count];
        int i = front;
        int index = 0;
        while(count>0){
            res[index++] = (T)elements[i];
            i++;
            i = i % arraySize;
            count--;
        }
        return res;
    }

    /**
     * 生成新的数组，并将原数组中的数据以队列的顺序移动到新数组中
     */
    private void growUp(){
        int newArraySize = arraySize * 2;
        Object[] newElements = new Object[newArraySize];
        int index = 0;
        for(T t : toArray()) {
            newElements[index] = elements[index];
            index++;
        }
        System.out.println(String.format("grow up from %d to %d",elements.length,newElements.length));
        rear = index;
        front = 0;
        elements = newElements;
        arraySize = elements.length;
    }
}
