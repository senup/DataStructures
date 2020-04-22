package day04_LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<8;i++){
            list.addFirst(i);
            System.out.println(list);
        }
        list.addLast(100);
        System.out.println(list);
        boolean res = list.contains(99);
        System.out.println(res);
        System.out.println(list.getSize());
    }
}
