package com.example.datastructor.Tree;

import org.junit.jupiter.api.Test;


public class InThreadBiTree {
    private ThreadNode root;
    public ThreadNode pre = null;

    public void setRoot(ThreadNode root) {
        this.root = root;
    }
    //中序遍历
    public void inorder() {
        if (this.root != null) {
            this.root.inorder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //对二叉树进行线索化
    public void createInThread(InThreadBiTree tree) {
        if (tree.root != null) {
            inThread(tree.root);
            pre.setRchird(null);
            pre.setRtag(1);
        }
    }

    //从结点p开始线索化
    public void inThread(ThreadNode p) {
        if (p != null) {
            inThread(p.getLchird());
            if (p.getLchird() == null) {
                p.setLchird(pre);
                p.setLtag(1);
            }
            if (pre != null && pre.getRchird() == null) {
                pre.setRchird(p);
                pre.setRtag(1);
            }
            pre = p;
            inThread(p.getRchird());
        }
    }
    //以结点p为根结点的子树的最左下结点
    public ThreadNode firstNode(ThreadNode p) {
        while (p.getLtag() == 0) {
            p = p.getLchird();
        }
        return p;
    }
    //结点p的后继结点
    public ThreadNode nextNode(ThreadNode p) {
        if (p.getRtag() == 0) {
            return firstNode(p.getRchird());
        }
        return p.getRchird();
    }

    //中序遍历线索二叉树
    public void inorder(InThreadBiTree tree) {
        for (ThreadNode p = firstNode(tree.root); p != null; p = nextNode(p)) {
            System.out.println(p);
        }
    }

    @Test
    public void test() {
        InThreadBiTree inThreadBiTree = new InThreadBiTree();

        ThreadNode node01 = new ThreadNode(1, "刘一");
        ThreadNode node02 = new ThreadNode(2, "陈二");
        ThreadNode node03 = new ThreadNode(3, "张三");
        ThreadNode node04 = new ThreadNode(4, "李四");
        ThreadNode node05 = new ThreadNode(5, "王五");
        ThreadNode node06 = new ThreadNode(6, "赵六");
        ThreadNode node07 = new ThreadNode(7, "钱七");
        inThreadBiTree.setRoot(node01);
        node01.setLchird(node02);
        node01.setRchird(node03);
        node02.setLchird(node04);
        node02.setRchird(node05);
        node03.setLchird(node06);
        node03.setRchird(node07);

        inThreadBiTree.inorder();
        System.out.println();
        //线索化二叉树
        createInThread(inThreadBiTree);
        inorder(inThreadBiTree);

    }
}
