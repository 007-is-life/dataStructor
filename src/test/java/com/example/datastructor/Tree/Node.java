package com.example.datastructor.Tree;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Node implements Comparable<Node>{
    private Integer number;
    private String name;
    private Node left;
    private Node right;

    public Node(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    public Node(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Node{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
    //从该结点开始先序遍历
    public void preorder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preorder();
        }
        if (this.right != null) {
            this.right.preorder();
        }
    }
    //从该结点开始中序遍历
    public void inorder() {
        if (this.left != null) {
            this.left.inorder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.inorder();
        }
    }
    //从该结点开始后序遍历
    public void postorder() {
        if (this.left != null) {
            this.left.postorder();
        }
        if (this.right != null) {
            this.right.postorder();
        }
        System.out.println(this);
    }

    //先序查找
    public Node preorderSearch(int number) {
        if (this.number == number) {
            return this;
        }
        Node resultNode = null;
        //对左节点进行先序查找
        if (this.left != null) {
            resultNode = this.left.preorderSearch(number);
        }
        if (resultNode != null) return resultNode;
        //对右结点进行先序查找
        if (this.right != null) {
            resultNode = this.right.preorderSearch(number);
        }
        return resultNode;
    }

    //中序查找
    public Node inorderSearch(int number) {
        Node resultNode = null;
        //对左节点进行中序查找
        if (this.left != null) {
            resultNode = this.left.inorderSearch(number);
        }
        if (resultNode != null) return resultNode;
        //对父节点进行查找
        if (this.number == number) {
            return this;
        }
        //对右结点进行中序查找
        if (this.right != null) {
            resultNode = this.right.inorderSearch(number);
        }
        return resultNode;
    }

    //后序查找
    public Node postorderSearch(int number) {
        Node resultNode = null;
        //对左节点进行后序查找
        if (this.left != null) {
            resultNode = this.left.postorderSearch(number);
        }
        if (resultNode != null) return resultNode;
        //对右结点进行后序查找
        if (this.right != null) {
            resultNode = this.right.postorderSearch(number);
        }
        if (resultNode != null) return resultNode;
        //对父结点进行查找
        if (this.number == number) {
            return this;
        }
        return null;
    }

    //删除结点，此方法把以待删结点为根的子树全删了
    public void delNode(int number) {
        if (this.left != null && this.left.number == number) {
            this.left = null;
        }
        if (this.right != null && this.right.number == number) {
            this.right = null;
        }
        if (this.left != null) {
            this.left.delNode(number);
        }
        if (this.right != null) {
            this.right.delNode(number);
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.getNumber()-o.getNumber();
    }
}
