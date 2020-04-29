package day07_Set;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("a-tale-of-two-cities(双城记)");
        ArrayList<String> word = new ArrayList<>();
        FileOperation.readFile("src\\day07_Set\\a-tale-of-two-cities.txt", word);
        System.out.println("total words: "+word.size());

        BSTSet<String> set = new BSTSet<>();
        for (String w:word) {
            set.add(w);
        }
        System.out.println("total different words: "+set.getSize());
    }
}