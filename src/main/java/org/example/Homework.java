package org.example;

public class Homework {
    static Node head;
    static Node tail;
    public class Node{
        int value;
        Node next;
        Node previous;
    }
    public static void print(){
        System.out.println();
        Node node = head;
        while (node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
    public void add(int value){
        Node node = new Node();
        node.value = value;

        if(tail == null){
            head = node;
        }else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
    }
    public static void revert (){
        Node curNode = head;
        if(curNode != null){
            while (curNode != null){
                Node next = curNode.next;
                Node previous = curNode.previous;
                curNode.next = previous;
                curNode.previous = next;
                if(previous == null){
                    tail = curNode;
                }
                if(next == null){
                    head = curNode;
                }
                curNode = next;
            }
        }else {
            System.out.println("List is empty");
        }
    }

    public static void main(String[] args){
        Homework list = new Homework();

        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }
        list.print();
        list.revert();
        list.print();
    }
}
