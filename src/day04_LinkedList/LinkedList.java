package day04_LinkedList;

public class LinkedList<E> {
    /*这里可以看到内部类Node为private是不暴露细节给外部的
    * 同时Node中的E以及next设置为public供外层使用*/
    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;//元素个数123456789，使用索引的时候记得最大到 数组【size-1】

    public LinkedList() {
        dummyHead=new Node(null,null);
        size=0;
    }

    //获取链表中的元素个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size==0;
    }



    //在链表中间添加e
    public void add(int index,E e){
        if(index<0 || index > size){
            throw new IllegalArgumentException("add failed because out of range");
        }
        //首先从头部开始，遍历到index-1的前一个位置在.next，在进行赋值
        Node prev=dummyHead;
        for(int i =0;i<index;i++){
            prev=prev.next;
        }
//            Node node = new Node(e);
//            node.next=prev.next;
//            prev.next=node;
        //等式右边完成了node赋值以及下一个节点的工作
        //等式左边完成node节点的前一个节点的工作
        prev.next=new Node(e,prev.next);
        size++;
    }
    //在链表头部添加一个e
    public void addFirst(E e){
        add(0,e);
    }
    //在链表末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }


    //获得链表的第index个位置的元素
    //在链表中不是一个常用的操作 练习用
    public E get(int index){
        if(index<0 || index>= size){
            throw new IllegalArgumentException("get failed because of illegal index;");
        }
        Node cur = dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e){
        Node cur= dummyHead.next;
        while(cur!=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    //从链表中删除index位置的元素，返回该元素
    public E remove(int index){
        if(index<0 || index >=size){
            throw new IllegalArgumentException("remove failed because of illegal index~");
        }
        Node prev= dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        Node retNode = prev.next;
        prev.next=retNode.next;
        retNode.next=null;
        size--;
        return retNode.e;
    }

    //从链表中删除第一个元素，返回该元素
    public E removeFirst(){
        return remove(0);
    }

    //从链表中删除最后一个元素，返回该元素
    public E removeLast(){
        return remove(size-1);
    }

    //从链表中删除某个元素
    //思路是先找到该元素在执行删除
    public void removeElement(E e){
        Node prev= dummyHead;
        while(prev.next!=null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev=prev.next;
        }

        if(prev.next!=null){
            Node delNode= prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            size--;
        }
    }



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        //从链表头开始遍历
//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur+"->");
//            cur=cur.next;
//        }
//        res.append("null");
        for(Node cur= dummyHead.next;cur!=null;cur=cur.next)
            res.append(cur+"->");
        res.append("null");
        return res.toString();
    }
}
