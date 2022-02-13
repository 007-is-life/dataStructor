package com.example.datastructor.circleSingleLinkedList;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;

public class Test1 {
    @Test
    public void test1() {
        CircleSingleLinkedList boyCircle = new CircleSingleLinkedList();
        boyCircle.add(5);
        boyCircle.countBoy(1, 2);
    }
}
