package day02_Stack;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int opCount=100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println(time1);
        LinkedListStack<Integer> listStack = new LinkedListStack<>();
        double time2 = testStack(listStack, opCount);
        System.out.println(time2);
    }

    private static double testStack(Stack<Integer> stack,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i=0;i<opCount;i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<opCount;i++){
            stack.pop();
        }
        long endTime = System.nanoTime();

        return (endTime-startTime)/1000000000.0;
    }


}
