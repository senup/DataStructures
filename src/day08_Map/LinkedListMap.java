package day08_Map;

import java.util.ArrayList;

public class LinkedListMap<K,V> implements Map<K,V> {
    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key,V value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }

        public Node(K key){
            this(key,null,null);
        }
        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString(){
            return key.toString()+":"+value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead=new Node();
        size=0;
    }


    //辅助方法：通过key获取整个节点
    private Node getNode(K key){
        Node cur = dummyHead.next;
        while(cur!=null){
            if(cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }


    @Override
    public void add(K key, V value) {
        //添加操作的话要保证映射key不能出现重复
        Node node = getNode(key);
        if(node==null){
            dummyHead.next=new Node(key,value,dummyHead.next);
            size++;
        }else
            node.value = value;

    }

    @Override
    public V remove(K key) {
        //比较麻烦的操作：找到前一个节点
        Node prev = dummyHead;
        while(prev.next!=null){
            if(prev.next.key.equals(key)){
              break;
            }
            prev=prev.next;
        }

        if(prev.next!=null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next=null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node==null?null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node==null)
            throw new IllegalArgumentException(key+"doesn't exist~~");
        node.value=newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }


    public static void main(String[] args) {
        System.out.println("双城记");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src\\day08_Map\\a-tale-of-two-cities.txt",words)){
            System.out.println("total words: "+ words.size());
            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for(String word:words){
                if(map.contains(word))
                    map.set(word,map.get(word)+1);
                else
                    map.add(word,1);
            }
            System.out.println("total different words: "+map.getSize());
            System.out.println("how many of 'was':"+map.get("was"));
            System.out.println("how many of 'were':"+map.get("were"));
        }
    }
}