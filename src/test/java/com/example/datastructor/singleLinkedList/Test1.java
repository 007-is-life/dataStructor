package com.example.datastructor.singleLinkedList;

import org.junit.jupiter.api.Test;

public class Test1 {
    @Test
    public void test() {
        SingleLinkedList heroLinkedList = new SingleLinkedList();
        Node node1 = new Node(1, "刘一", "liuyi");
        Node node2 = new Node(2, "陈二", "chener");
        Node node3 = new Node(3, "张三", "zhangsan");
        Node node4 = new Node(4, "李四", "lisi");
        heroLinkedList.addByOrder(node1);
        heroLinkedList.addByOrder(node4);
        heroLinkedList.addByOrder(node2);
        heroLinkedList.addByOrder(node3);
        //测试方法findLastIndexNode()
//        System.out.println(heroLinkedList.findLastIndexNode(45));
        //反转链表
//        heroLinkedList.reverse();
//        heroLinkedList.list();
        //逆序打印单链表
        heroLinkedList.reversePrint();
//        heroLinkedList.list();
//
//        heroLinkedList.update(new Node(3,"张三啊","zhangSan"));
//        heroLinkedList.list();
//
//        System.out.println();
//        heroLinkedList.delete(3);
//        heroLinkedList.list();
//        System.out.println(heroLinkedList.length());

    }

    @Test
    public void test2() {
        final Node node;

    }


}
