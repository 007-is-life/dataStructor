package com.example.datastructor.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(3);
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
                        System.out.println();
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
//用数组模拟循环队列，front指向队头元素，rear指向队尾元素，数组中空一位不填充数据。
class CircleQueue {
    int maxsize,front,rear;
    int[] arr;

    public CircleQueue(int maxsize) {
        this.maxsize = maxsize;
        front = 0;
        rear = 0;
        arr = new int[maxsize];
    }

    public boolean isFull() {
        return front == (rear + 1) % maxsize;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int value) {
        if (isFull()) throw new RuntimeException("队列已满");
        arr[rear] = value;
        rear = (rear + 1) % maxsize;
    }

    public int getQueue() {
        if (isEmpty()) throw new RuntimeException("队列为空");
        int value = arr[front];
        front = (front + 1) % maxsize;
        return value;
    }

    //判断队列中的有效元素个数
    public int size() {
        return (rear + maxsize - front) % maxsize;
    }

    //遍历队列
    public void showQueue() {
        if (isEmpty()) throw new RuntimeException("队列为空");
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\t", i % maxsize, arr[i % maxsize]);
        }
        System.out.println();
    }

    //查看头元素
    public int headQueue() {
        if (isEmpty()) throw new RuntimeException("队列为空");
        return arr[front];
    }
}
