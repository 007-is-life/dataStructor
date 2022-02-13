package com.example.datastructor.Tree;

import org.junit.jupiter.api.Test;

public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Test
    public void test() {
        Person person = new Person();
        person.name="张三";
        System.out.println(person.name);
        Person person2 = new Person();
    }
}
