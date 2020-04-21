package day02_stack;


public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    /*构造函数*/
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array=new Array<> ();
    }

    @Override
    public void push(E e) {
        //压入 ：即在后面添加一个新的元素
        array.addLast(e);
    }

    @Override
    public E pop() {
        //弹出：即移除最后面的元素
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    //获取容量
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("Stack: [");
        for (int i =0 ; i <array.getSize();i++ ){
            res.append(array.get(i));
            if(i!=array.getSize()-1)
                res.append(",");
        }
        res.append("] top");
        return res.toString();//返回构造的字符串

    }
}
