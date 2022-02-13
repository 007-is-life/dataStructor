package com.example.datastructor.Tree;

import com.example.datastructor.HashTable.HashTable;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Hashtable;

public class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    //先序遍历
    public void preorder() {
        if (this.root != null) {
            this.root.preorder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //中序遍历
    public void inorder() {
        if (this.root != null) {
            this.root.inorder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //后序遍历
    public void postorder() {
        if (this.root != null) {
            this.root.postorder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //先序查找
    public Node preorderSearch(int number) {
        if (this.root != null) {
            return this.root.preorderSearch(number);
        }else return null;
    }
    //中序查找
    public Node inorderSearch(int number) {
        if (this.root != null) {
            return this.root.inorderSearch(number);
        }else return null;
    }
    //后序查找
    public Node postorderSearch(int number) {
        if (this.root != null) {
            return this.root.postorderSearch(number);
        }else return null;
    }

    //删除结点
    public void delNode(int number) {
        if (this.root != null) {
            if (this.root.getNumber() == number) {
                this.root = null;
            } else {
                root.delNode(number);
            }
        }
    }

    @Test
    public void test() {
        //创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        Node node01 = new Node(1, "刘一");
        Node node02 = new Node(2, "陈二");
        Node node03 = new Node(3, "张三");
        Node node04 = new Node(4, "李四");
        Node node05 = new Node(5, "王五");
        Node node06 = new Node(6, "赵六");
        Node node07 = new Node(7, "钱七");
        binaryTree.setRoot(node01);
        node01.setLeft(node02);
        node01.setRight(node03);
        node02.setLeft(node04);
        node02.setRight(node05);
        node03.setLeft(node06);
        node03.setRight(node07);

        binaryTree.preorder();
        System.out.println();
//        System.out.println(binaryTree.inorderSearch(6));
        binaryTree.delNode(3);
        binaryTree.preorder();

    }



}


