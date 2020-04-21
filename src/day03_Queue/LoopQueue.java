package day03_Queue;

import java.util.NoSuchElementException;

public class LoopQueue<E> implements Queue<E> {
    //数组 前后两个指针 当前数组元素个数
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        //用户不知道，真实容量要加1
        data = (E[]) new Object[capacity + 1];
        front = 0;
        size = 0;
        tail = 0;
    }

    public LoopQueue() {
        //调用父类的构造方法this()
        this(10);
    }

    public int getCapacity() {
        //有一个单位被有意识浪费掉，真正计数的时候要减去
        //用户不知道 真实容量应该减一
        return data.length - 1;
    }


    @Override
    public void enqueue(E e) {
        //判断队列是否满-》扩容 确保有足够的空间
        if ((tail + 1) % data.length == front) {
            //为什么要浪费一个空间呢？
            resize(getCapacity() * 2);
        }
        //扩容操作新增一个数，同时tail随着环形进行移动，元素个数加一
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        //从front开始遍历数组
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        //队列是否为空
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        }
        //返回出队的数
        E ret = data[front];
        data[front] = null;
        //front出队后 则由后一个取代
        front = (front + 1) % data.length;
        size--;
        //如果元素个数小于数组长度的四分之一则触发缩容操作 缩容成一半
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty queue");
        }
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {//把front错写成0,导致代码出错
            res.append(data[i]);
            //若不为最后一个元素，则添加逗号
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            //每添加三个元素就取出一个元素,3-1=2,【2 5 8】
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}
