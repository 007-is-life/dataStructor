package com.example.datastructor.circleSingleLinkedList;

public class CircleSingleLinkedList {
    //约瑟夫问题
    private CircleSingleNode first = null;

    public void add(int num) {
        if (num < 1) {
            System.out.println("num的值必须大于0");
            return;
        }
        CircleSingleNode cur = null;    //这里为什么必须要初始化变量
        for (int i = 1; i <= num; i++) {
            CircleSingleNode temp = new CircleSingleNode(i);    //待插结点
            if (i == 1) {
                first = temp;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(temp);
                cur = cur.getNext();
                cur.setNext(first);
            }
        }
    }

    public void show() {
        if (first == null) {
            System.out.println("循环单链表为空");
            return;
        }
        CircleSingleNode cur = first;
        while (true) {
            System.out.println(cur);
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
    }
    //求循环单链表的长度
    public int size() {
        int count = 0;
        CircleSingleNode cur = first;
        while (cur.getNext() != first) {
            count++;
            cur = cur.getNext();
        }
        return ++count;
    }

    //k是第几个结点开始报数，m是报到第几个数，圆中结点从1开始算起
    public void countBoy(int k, int m) {
        if (first == null || k < 1 || k > size()) {
            System.out.printf("输入的k值不合法，1<k<%d", size());
            return;
        }
        //调help指针的初始位置，使其指向循环单链表的尾结点
        CircleSingleNode help = first;
        while (help.getNext() != first) {
            help = help.getNext();
        }
        //开始报数前，调节first和help指针的位置，使first指向第一个报数的结点，使help指向first的前驱结点
        for (int i = 0; i < k - 1; i++) {
            first = first.getNext();
            help = help.getNext();
        }
        //开始报数
        while (first != help) {
            for (int i = 0; i < m - 1; i++) {
                first = first.getNext();
                help = help.getNext();
            }
            System.out.printf("num=%d的结点出圈\n", first.getNum());
            first = first.getNext();
            help.setNext(first);
        }
        //报数完毕，first、help指向最后一个结点
        System.out.printf("最后一个结点是num=%d", first.getNum());
    }
}
