package day09_MaxHeap;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        //将数组转化成动态数组
        data = new Array<>(arr);
        //从后往前遍历 下沉
        for (int i = parent(arr.length - 1); i >= 0 ; i--) {
            siftDown(i);
        }
    }

    //返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index0 does not have parent~");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    //添加元素
    public void add(E e) {
        data.addLast(e);
        //将该元素上浮,参数为索引值
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        //父节点的值和该节点作比较,compareto这个方法我一直理解为类似减法
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //查看堆中的最大元素
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("empty heap!");
        }
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax() {
        E ret = findMax();
        //交换位置再删除最后一个元素
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        //整理堆
        //让索引为0的元素下沉
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        //左孩子越界的时候条件终止
        while (leftChild(k) < data.getSize()) {
            //找到左右节点中数值较大的那个
            //左孩子
            int j = leftChild(k);
            //右孩子
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            //data[i]是左右节点中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    //取出堆中的最大元素，并且替换成元素e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


}
