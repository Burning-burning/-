package com.shx.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);

        char key = ' ';//接收用户的输入
        Scanner in = new Scanner(System.in);

        boolean loop = true;
        // 输出一个菜单
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            key = in.next().charAt(0); //接收一个字符

            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = in.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try{
                        int res = arrayQueue.headQueue();
                        System.out.printf("取出的头数据：%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());

                    }
                    break;
                case 'e':
                    in.close();
                    loop = false;
                    break;

                default:


            }

        }
        System.out.println("程序退出");



    }
}


// 使用数组模拟队列，编写一个arrayqueue的类
class ArrayQueue{
    private int maxSize; //表示数组最大的容量
    private int front; //队列tou,front是指向队列头的前一个位置
    private int rear; // 指向队列尾的具体位置
    private int[] arr;

    // 创建队列的构造器
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        front  = -1;  //队列头
        rear = -1; //队列尾
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return rear == maxSize-1;
    }


    public boolean isEmpty(){
        return rear == front;
    }


    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];


    }
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空，没数据");
            return;
        }
        for (int i = 0; i<arr.length;i++){
            System.out.printf("arr[%d]=%d\t",i,arr[i]);
        }
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("数据空");
        }
        return arr[front+1];
    }

}
