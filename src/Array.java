

public class Array<E> {
    //声明数组
    private E[] data;
    //数组的元素个数
    private int size;


    //构造函数：往data中传入capacity 初始化长度size
    public Array(int capacity){
        //数组的容量
        data = (E[]) new Object[capacity];
        //定义最初的个数
        size=0;
    }

    //无参构造函数，默认数组的容量为capacity=10
    public Array(){
        this(10);
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //获取数组中的元素个数
    public int getSize(){
        return size;
    }


    //返回的数组是否为空
    public boolean isEmpty() {
        return size==0;
    }

//    //向所有元素后添加一个新元素
//    public void addLast(int e){
//        //由于是往后插入数值，那么对数组越界做异常处理
//        if(size==data.length)
//            throw new IllegalStateException("AddLast failed.Array is full~");
//        //思路是根据size元素个数来赋值，同时size后移一位
//        data[size]=e;
//        size++;
//    }
//
//
//
//    //向所有元素前添加一个新元素
//    public void addFirst(int e){
//        //思路是先将除第0个元素外的所有元素，从后面开始逐个后移一位，再处理data[0]=e
//        for(int i=size-1;i>=0;i--){
//            data[i+1]=data[i];
//        }
//        data[0]=e;
//        //下标向后移一位
//        size++;
//    }

        //向所有元素后添加一个新元素
    public void addLast(E e){
        add(size,e);
    }

        //向所有元素前添加一个新元素
    public void addFirst(E e){
        add(0,e);
    }

    //在index索引的位置插入一个新的元素e
    public void add(int index,E e){
        //思路是先将索引后的所有元素，从后面开始逐个后移一位，再处理data[index]=e


        if(index<0 || index >size)
            throw new ArrayIndexOutOfBoundsException("out of range~");

        if(size==data.length)
            resize(2*data.length);
            
        for(int i=size-1;i>=index;i--)
            data[i+1]=data[i];
        data[index]=e;
        //下标向后移一位
        size++;
    }

    //数组扩容
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i=0;i<size;i++){
            newData[i]=data[i];
        }
        data=newData;
    }


    //获取index索引位置的元素
    public E get(int index){
        if(index<0 || index>=size)
            throw new ArrayIndexOutOfBoundsException("Get fail because out of range");

        return data[index];
    }

    //修改index所有位置的元素为e
    public void set(int index,E e){
        if(index<0 || index>=size)
            throw new ArrayIndexOutOfBoundsException("Set fail because out of range");
        data[index]=e;
    }

    //查找数组中是否有元素e
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    //查找元素e所在的索引，如果不存在该元素，则返回-1
    public int find(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回该位置的元素
    public E remove(int index){
        //思路是删除该位置，那么后面的元素应该往前移，同时数组的元素个数-1
        if(index<0 || index>= size)
            throw new ArrayIndexOutOfBoundsException("index is illegal~");
        E res = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1]=data[i];//后置赋值前置
        }
        size--;
        //loitering objects != memory leak
        data[size]=null;//data[size]最后的值，此时还指着一个类对象引用，为了让垃圾回收机制将其回收]
        if(size==data.length/4 && data.length/2!=0){//第二个条件防止了 data.length缩容到1时出现0的情况
            resize(data.length/2);
        }
        return res;
    }

    //从数组中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    //从数组中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size-1);
    }

    //从数组中删除元素e
    public void removeElement(E e){
        int index=find(e);
        if (index!=-1){
            remove(index);
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i=0;i<size;i++){
            res.append(data[i]);
            //若不为最后一个元素，则添加逗号
            if(i!=size-1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
