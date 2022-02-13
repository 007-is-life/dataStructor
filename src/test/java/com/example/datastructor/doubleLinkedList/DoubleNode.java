package com.example.datastructor.doubleLinkedList;

public class DoubleNode {
    int num;
    String name;
    String nickName;
    DoubleNode pre;
    DoubleNode next;

    public DoubleNode(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
