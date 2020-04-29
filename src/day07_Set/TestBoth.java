package day07_Set;

import java.util.ArrayList;

public class TestBoth {
    public static void main(String[] args) {
        String filename = "src\\day07_Set\\a-tale-of-two-cities.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set :"+time1+" S");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("linkedList Set :"+time2+" S");
    }

    private static double testSet(Set<String> set,String filename){
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename,words)){
            System.out.println("total words:" + words.size());
            for (String word: words) {
                set.add(word);
            }
            System.out.println("total different words "+ set.getSize());
        }

        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }


}
