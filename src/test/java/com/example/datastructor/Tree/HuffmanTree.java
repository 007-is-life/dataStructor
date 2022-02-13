package com.example.datastructor.Tree;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;

//根据一组数据构造一颗Huffman树
public class HuffmanTree {
    private Node root;

    public HuffmanTree(int[] a) {
        this.root = createHuffmanTree(a);
    }

    public HuffmanTree() {
    }

    //中序遍历
    public void inorder() {
        if (this.root != null) {
            this.root.inorder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public Node createHuffmanTree(int[] a) {
        LinkedList<Node> list = new LinkedList<>();
        for (int i : a) {
            list.add(new Node(i));
        }

        while (list.size() > 1) {
            Collections.sort(list);
            Node left = list.get(0);
            Node right = list.get(1);
            Node root = new Node(left.getNumber() + right.getNumber());
            root.setLeft(left);
            root.setRight(right);
            list.remove(left);
            list.remove(right);
            list.add(root);
        }
        return list.get(0);
    }

    @Test
    public void test() {
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.createHuffmanTree(new int[]{1, 3, 7, 6, 8, 29, 13});
        huffmanTree.inorder();

    }

    public static void main(String[] args) {
        HuffmanTree huffmanTree = new HuffmanTree(new int[]{1, 3, 7, 6, 8, 29, 13});
        huffmanTree.inorder();
    }

}
