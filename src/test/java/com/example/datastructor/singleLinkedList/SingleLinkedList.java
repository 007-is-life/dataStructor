package com.example.datastructor.singleLinkedList;

import java.util.Stack;

public class SingleLinkedList {
    Node head;

    public SingleLinkedList() {
        head = new Node(0, "", "");
    }
    //添加，在单链表的尾部插入新结点
    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }
    //按照结点的num顺序进行插入
    public void addByOrder(Node node) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (node.num < temp.next.num) {
                break;
            } else if (temp.next.num == node.num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的编号%d已经存在\n", node.num);
        }else {
            node.next = temp.next;
            temp.next = node;
        }
    }
    //遍历单链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
    //更新，根据node结点中的num编号更新链表中相应结点的数据域
    public void update(Node node) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        boolean flag = false;
        while (temp != null) {
            if (temp.num == node.num) {
                flag = true;
                break;  //此时temp指向目标结点
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.printf("链表中没有编号为%d的结点",node.num);
        }
    }
    //根据node结点的num删除链表中对应的结点
    public void delete(int num) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.num == num) {
                flag = true;
                break;  //temp指向目标结点的前驱
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("链表中不存在num=%d的结点", num);
        }
    }

    //求单链表有效结点的个数
    public int length() {
        Node temp = head;
        int length = 0;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    //取倒数第k个结点
    public Node findLastIndexNode(int k) {
        if (head.next == null) {
            System.out.println("链表为空");
            return null;
        }
        Node temp = head.next;
        if (k <= 0 || k > length()) {
            System.out.println("输入参数不在范围内");
            return null;
        } else {
            for (int i = 0; i < length()-k; i++) {
                temp = temp.next;   //此时temp指向目标结点
            }
            return temp;
        }
    }
    //反转链表
    public void reverse() {
        if (this.head == null || this.head.next == null) {
            System.out.println("单链表必须至少两个结点才能反转");
            return;
        }
        Node reverseHead = new Node(0, "", "");
        Node cur = head.next;   //指向待插结点
        Node next = null;   //指向cur指针后继，防止原链表丢失
        while (cur != null) {
            next = cur.next;    //next指针后移一位
            cur.next = reverseHead.next;    //头插法：把第一个结点的指针赋给待插结点的指针域
            reverseHead.next = cur;     //把待插结点的指针赋给头结点的指针域
            cur = next; //cur指针后移一位
        }
        head.next = reverseHead.next;
    }

    //逆序打印单链表
    public void reversePrint() {
        Stack<Node> stack = new Stack<>();
        Node cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
