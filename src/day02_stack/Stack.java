package day02_stack;

public interface Stack<E> {
    /*栈的操作后入先出，因此有压入，弹出，查看栈顶元素，获取元素个数，是否为空*/

    void push(E e);
    E pop();
    E peek();
    int getSize();
    boolean isEmpty();


}
