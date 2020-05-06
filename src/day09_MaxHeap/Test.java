package day09_MaxHeap;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
//        int n = 1000000;
//        MaxHeap<Integer> maxHeap = new MaxHeap<>();
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
//        }
//
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = maxHeap.extractMax();
//        }
//
//        for (int i = 1; i < n; i++) {
//            if (arr[i - 1] < arr[i]) {
//                throw new IllegalArgumentException("error");
//            }
//
//        }
//        System.out.println("test maxheap completed");


        int n =1000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i]=random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, false);
        System.out.println("without heapify:"+time1+"s");
        double time2 = testHeap(testData, true);
        System.out.println("with heapify:"+time2+"s");

    }

    private static double testHeap(Integer[] teatData, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(teatData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int num : teatData) {
                maxHeap.add(num);
            }
        }

        int[] arr = new int[teatData.length];
        for (int i = 0; i < teatData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < teatData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("error");
            }

        }
        System.out.println("test maxheap completed");

        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

}
