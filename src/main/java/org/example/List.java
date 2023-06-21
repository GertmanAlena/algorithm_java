package org.example;

public class List { //разворот двусвязного списка
    Node head;
    Node tail;

//    public void pushStec (int value){ //для стека
//        Node node = new Node(); // создали новую ноду
//        node.value = value; //заполнили новую ноду
//        node.next = head;
//        head = node;
//    }
//    public Integer pop(){ // Для стека
//        Integer result = null;
//        if(head != null){
//            result = head.value;
//            head = head.next;
//        }
//        return result;
//    }

    public void push (int value){   //для очереди
        Node node = new Node();   // создали новую ноду
        node.value = value;   //заполнили новую ноду
        node.next = head;
        node.previous = node;
        head = node;
    }

    public Integer peek() {   //для очереди
        Integer result = null;
        if(tail!= null){
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }

    public void add(int value){
        Node node = new Node(); // создали новую ноду
        node.value = value; //заполнили новую ноду
        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }
    public void add(int value, Node node){
        Node next = node.next;

        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null){
            tail = newNode;
        }else{
            next.previous = newNode;
            newNode.next = next;
        }
    }
    public void del(Node node){
        Node previous = node.previous;
        Node next = node.next;

        if (previous == null){
            next.previous = null;
            head = next;
        }else {
            if (next == null){
                previous.next = null;
                tail = previous;
            } else {
                next.previous = previous;
                previous.next = next;
            }
        }
    }
    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null){
            if (currentNode.value == value){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    public void revert(){
        Node currentNode = head;
        while (currentNode!= null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null){
                tail = currentNode;
            }
            if (next == null){
                head = currentNode;
            }
            currentNode = next;
        }
    }
    public  class Node{
        int value;
        Node next;
        Node previous;
    }
}
//public class List { //разворот односвязного списка
//    Node head;
//    public void reset() {
//        if (head != null && head.next != null) {
//            Node temp = head;
//            revert(head.next, head);
//            temp.next = null;
//        }
//    }
//    private void revert(Node currentNode, Node previousNode){
//        if(currentNode.next == null) {
//             head = currentNode;
//        } else {
//            revert(currentNode.next, currentNode);
//        }
//        currentNode.next = previousNode;
//    }
//    public  class Node{
//        int value;
//        Node next;
//    }
//}