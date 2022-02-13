package com.example.datastructor.Tree;

import lombok.Data;

@Data
public class ThreadNode {
    private int num;
    private String name;
    private int ltag = 0;
    private int rtag = 0;
    private ThreadNode lchird;
    private ThreadNode rchird;

    public ThreadNode(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ThreadNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    //从该结点开始中序遍历
    public void inorder() {
        if (this.lchird != null) {
            this.lchird.inorder();
        }
        System.out.println(this);
        if (this.rchird != null) {
            this.rchird.inorder();
        }
    }


}
