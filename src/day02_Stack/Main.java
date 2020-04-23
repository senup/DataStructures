package day02_Stack;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i=0;i<10;i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);


        ArrayStack<Girl> arrayStack = new ArrayStack<>();
        arrayStack.push(new Girl("阿曼"));
        arrayStack.push(new Girl("阿真"));
        arrayStack.push(new Girl("阿慧"));
        arrayStack.push(new Girl("阿果"));
        System.out.println(arrayStack);
        System.out.println(arrayStack.getSize());
        for(int i=0;i<4;i++){//一开始4的位置我写的是arrayStack.getSize(),运行了两次就不在运行了，后面发现size随着下面的pop会改变，
            //我期望执行四次。但弹出第一次，数组的size就变为3了；弹出第二次的时候，i=2，2《3还能运行，size为2;到第三次的时候i=3>2程序没运行，所以才会运行两次
            arrayStack.pop();
            System.out.println(arrayStack);
        }


    }

}
