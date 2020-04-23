package day03_Queue;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int opCount=100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("arrayQueue runTime: "+time1+"s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("loopQueue runTime: "+time2+"s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("loopQueue runTime: "+time3+"s");

    }

    //测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位-秒
    private static double testQueue(Queue<Integer> q,int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i=0;i<opCount;i++){
            //nextInt在方法调用返回介于0(含)和n(不含)伪随机，均匀分布的int值。
            //在JDK中，整形类型是有范围的，最大值为Integer.MAX_VALUE，即2147483647，最小值为Integer.MIN_VALUE -2147483648。
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<opCount;i++){
           q.dequeue();
        }

        long endTime = System.nanoTime();

        //纳秒和秒 倍率为 九次方，除数小数点后一个零能够格式化秒为double型
        return (endTime-startTime)/1000000000.0;
    }
}
