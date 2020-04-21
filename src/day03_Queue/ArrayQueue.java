package day03_Queue;

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public void enqueue(E e) {
       array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    //获取容量 基于动态数组
    public int getCapacity(){
        return array.getCapacity();
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            //若不为最后一个元素，则添加逗号
            if(i!=array.getSize()-1)
                res.append(", ");
        }
        res.append("] tail ");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);
            //每添加三个元素就取出一个元素,3-1=2,【2 5 8】
            if(i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}
