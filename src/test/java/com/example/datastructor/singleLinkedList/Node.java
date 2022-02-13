package com.example.datastructor.singleLinkedList;

import lombok.Data;

@Data
public class Node {
    int num;
    String name;
    String nickName;
    Node next;

    public Node(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

