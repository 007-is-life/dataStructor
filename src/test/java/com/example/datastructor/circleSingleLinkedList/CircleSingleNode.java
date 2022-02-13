package com.example.datastructor.circleSingleLinkedList;

import lombok.Data;

@Data
public class CircleSingleNode {
    private int num;
    private CircleSingleNode next;

    public CircleSingleNode(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "CircleSingleNode{" +
                "num=" + num +
                '}';
    }
}
