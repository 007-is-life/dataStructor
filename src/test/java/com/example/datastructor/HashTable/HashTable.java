package com.example.datastructor.HashTable;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

public class HashTable<I extends Number, I1 extends Number> {

    private NodeList[] hashTable;
    private final int size;

    public HashTable(int size) {
        this.size = size;
        this.hashTable = new NodeList[this.size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new NodeList();
        }
    }

    public int hashFun(Node node) {
        return node.getId() % this.size;
    }

    public void add(Node node) {
        hashTable[hashFun(node)].add(node);
    }

    public void traverse() {
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i].traverse();
        }
    }

    public Node findNodeById(int id) {
        return hashTable[id % 10].findNodeById(id);
    }


    public static void main(String[] args) {
        HashTable<Number, Number> hashTable = new HashTable<Number, Number>(3);
        hashTable.add(new Node(1, "刘一"));
        hashTable.add(new Node(2, "陈二"));
        hashTable.add(new Node(3, "张三"));
        System.out.println(hashTable.findNodeById(2));
        System.out.println();
        hashTable.traverse();
    }
}

@Data
@NoArgsConstructor
class Node {
    private int id;
    private String name;
    private Node next;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class NodeList {
    private Node first;

    public void add(Node node) {
        if (first == null) {
            first = node;
        } else {
            Node cur = first;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            cur.setNext(node);
        }
    }

    public void traverse() {
        if (first != null) {
            Node cur = first;
            while (cur != null) {
                System.out.println(cur);
                cur = cur.getNext();
            }
        }

    }

    public void remove(Node node) {
        if (first != null) {
            if (first.getId() == node.getId()) {    //删除第一个结点
                first = first.getNext();
            } else {    //删除非第一个结点
                Node pre = first;
                Node cur = pre.getNext();
                while (cur.getId() != node.getId()) {
                    if (cur.getNext() != null) {
                        pre = cur;
                        cur = cur.getNext();
                    } else {
                        return;
                    }
                }
                pre.setNext(cur.getNext());
            }
        }

    }

    public Node findNodeById(int id) {
        if (first != null) {
            Node cur = first;
            while (cur.getId() != id) {
                cur = cur.getNext();
            }
            return cur;
        }else return null;
    }

    @Test
    public void test() {
        NodeList nodeList_01 = new NodeList();
        nodeList_01.add(new Node(1, "刘一"));
        nodeList_01.add(new Node(2, "陈二"));
        nodeList_01.add(new Node(3, "张三"));
        nodeList_01.traverse();
        nodeList_01.remove(new Node(4, "陈二"));
        nodeList_01.traverse();
        System.out.println(nodeList_01.findNodeById(2));
    }

    @Test
    public void test2() {
        NodeList nodeList = new NodeList();
        Node first = nodeList.first;
        if (first.getNext() == null) {  //first为null的时候不能调用方法了。
            System.out.println("a");
        } else {
            System.out.println("b");
        }
    }

}
