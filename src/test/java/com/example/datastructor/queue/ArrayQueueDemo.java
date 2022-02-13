package com.example.datastructor.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("s(show),显示队列");
            System.out.println("a(add),添加数据");
            System.out.println("g(get),队头出对");
            System.out.println("h(head),查看队头元素");
            System.out.println("请输入操作");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("请输入要入队的值");
                    int value = scanner.nextInt();
                    try {
                        queue.addQueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int headValue = queue.getQueue();
                        System.out.printf("取出的数据是:%d", headValue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队头元素是:%d", res);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
//数组只能使用一次
class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int value) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        } else {
            rear++;
            arr[rear] = value;
        }
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            front++;
            return arr[front];
        }
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = front+1; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\t", i, arr[i]);
        }
        System.out.println();
    }

    public int headQueue() {
        if (isEmpty()) throw new RuntimeException("队列为空");
        return arr[front + 1];
    }
}
