package com.example.datastructor.doubleLinkedList;

public class DoubleLinkedList {
    DoubleNode head;

    public DoubleLinkedList() {
        head = new DoubleNode(0, "", "");
    }

    //遍历，顺序遍历双向链表
    public void list() {
        DoubleNode temp = head.next;
        if (temp == null) {
            System.out.println("双向链表为空");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加，在双向链表尾部添加新的结点
    public void add(DoubleNode doubleNode) {
        DoubleNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = doubleNode;
        doubleNode.pre = temp;
    }

    //删除，根据doubleNode的num字段删除相应的结点
    public void delete(int num) {
        DoubleNode temp = head.next;
        boolean flag = false;
        if (temp == null) {
            System.out.println("双向链表为空");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.num == num) {
                flag =true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("num=%d的目标结点不存在", num);
        }
    }

    //更新结点,根据新结点的num字段更新双链表中的相应结点
    public void update(DoubleNode doubleNode) {
        DoubleNode temp = head.next;
        boolean flag = false;
        if (temp == null) {
            System.out.println("双向链表为空");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.num == doubleNode.num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            if (temp.next != null) {    //如果temp是尾结点，不需要执行下面这两句
                doubleNode.next = temp.next;
                temp.next.pre = doubleNode;
            }
            temp.pre.next = doubleNode;
            doubleNode.pre = temp.pre;
        } else {
            System.out.printf("num=%d的目标结点不存在", doubleNode.num);
        }
    }
}
