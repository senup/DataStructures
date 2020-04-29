package day07_Set;

        import java.util.ArrayList;
        import java.util.List;

//线性数据结构不要求具有可比性
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("a-tale-of-two-cities(双城记)");
        ArrayList<String> word = new ArrayList<>();
        FileOperation.readFile("src\\day07_Set\\a-tale-of-two-cities.txt", word);
        System.out.println("total words: "+word.size());

        LinkedListSet<String> set = new LinkedListSet<>();
        for (String w:word) {
            set.add(w);
        }
        System.out.println("total different words: "+set.getSize());
    }
}
