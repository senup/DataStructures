package day01_Array;

public class Main {

    public static void main(String[] args) {
//        //声明数组 通过长度
//        int[] arr= new int[10];
//        for (int i=0;i<arr.length;i++) {
//            arr[i]=i;
//        }
//
//
//        //声明数组 通过提前赋值
//        int[] scores= new int[]{100,99,88,77,66,5,4,3};
//        //循环打印数组
//        for(int i=0;i<scores.length; i++){
//            System.out.print(scores[i]+" ");
//        }
//        System.out.println();
//        for (int score:scores) {
//            System.out.print(score+" ");
//        }
//        System.out.println();
//
//        //增删改查
//        scores[0] = 999;
//        for (int score:scores
//             ) {
//            System.out.print(score);
//        }
//        System.out.println("=======================");
        Array<Integer> array = new Array<>(20);
        for(int i=0;i<10;i++){
            array.addLast(i);
        }
        System.out.println(array);
        array.addLast(1);
        array.addFirst(2);
        System.out.println(array);



//
//
//
//        day01_Array.Array array = new day01_Array.Array(20);
//        for(int i=0;i<10;i++){
//            array.addLast(i);
//        }
//        System.out.println(array);
//        array.addLast(999);
//        array.addFirst(1111111);
//        System.out.println(array);
//        System.out.println(array.get(4));
//        array.set(11,12138);
//        System.out.println(array);
//        array.remove(0);
//        System.out.println(array);



    }
}
