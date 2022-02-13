package com.example.datastructor.doubleLinkedList;

import org.junit.jupiter.api.Test;

public class Test1 {
    @Test
    public void test1() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleNode doubleNode1 = new DoubleNode(1, "刘一", "liuyi");
        DoubleNode doubleNode2 = new DoubleNode(2, "陈二", "chener");
        DoubleNode doubleNode3 = new DoubleNode(3, "张三", "zhangsan");
        DoubleNode doubleNode4 = new DoubleNode(4, "李四", "lisi");
        DoubleNode doubleNode5 = new DoubleNode(3, "李四啊", "LISI");
        doubleLinkedList.add(doubleNode1);
        doubleLinkedList.add(doubleNode2);
        doubleLinkedList.add(doubleNode3);
        doubleLinkedList.add(doubleNode4);
        //顺序遍历双链表
        doubleLinkedList.list();
        //更新双链表
        doubleLinkedList.update(doubleNode5);
        doubleLinkedList.list();
        //删除双链表的结点
        doubleLinkedList.delete(3);
        doubleLinkedList.list();

    }
}
