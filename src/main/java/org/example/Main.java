package org.example;

class HashMapp {

    class Entity {  //сущность
        int key;
        int value;
    }
    class Basket{   //корзина для обработки объектов
        Node head;
        class Node {
            Entity entity;
            Node next;
        }
        public Integer find(int key) {
            Node node = head;
            while (node!= null) {
                if (node.entity.key == key) {
                    return node.entity.value;
                }
                node = node.next;
            }
            return null;   //если дошли до конца цикла и не нашли
        }
        public boolean push(Entity entity) {
            Node node = new Node();
            node.entity = entity;
            if (head == null) {
                head = node;
            } else {
                if(head.entity.key == entity.key) {
                    return false;
                } else {Node currentNode = head;
                    while (currentNode.next != null) {
                        if (currentNode.next.entity.key == entity.key) {   //если такой же элемент найден
                            return false;
                        }
                        currentNode = currentNode.next;
                    }
                    currentNode.next = node;
                }
            }
            return true;
        }
        public boolean remove(int key) {
            if (head != null) {
                if(head.entity.key == key) {
                    head = head.next;
                    return true;
                } else {
                    Node currentNode = head;
                    while (currentNode.next != null) {
                        if (currentNode.next.entity.key == key) {   //если такой же элемент найден
                            currentNode.next = currentNode.next.next;
                            return true;
                        }
                        currentNode = currentNode.next;
                    }
                }
            }
            return false;
        }
    }
    //размер массива (размер hashMAp начинается с 16)
    static final int INIT_SIZE = 16;
    Basket[] baskets;   //массив корзинок

    public HashMapp(){
        this(INIT_SIZE);
    }
    public HashMapp(int size){
        baskets = new Basket[size];
    }
    private int getIndex(int key){
        return key % baskets.length;   //Возвражает индекс элемента
    }

    public Integer find(int key){
        int index = getIndex(key);
        Basket bucket = baskets[index];
        if(bucket != null){   // если корзина не найдена
            return bucket.find(key);
        }
        return null;   // Объект не найдет, т.к. нет корзины
    }
    public boolean push(int key, int value) {
        int index = getIndex(key);   //находим индекс
        Basket basket = baskets[index];   //находим корзину
        if(basket == null){   // если корзина не найдена, создаём её
            basket = new Basket();
            baskets[index] = basket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        return basket.push(entity);
    }
    public boolean remove(int key) {
        int index = getIndex(key);   //находим индекс
        Basket basket = baskets[index];   //находим корзину
        if(basket != null){   // если корзина
            return basket.remove(key);
        }
        return false;
    }
}
class Tree{
    Node root;
    class Node{
        int value;
        Node left;
        Node right;
    }

    public Node find(int value){
        return find(root, value);
    }
    private Node find(Node node, int value){
        if(node == null){
            return null;
        }
        if(node.value == value){
            return node;
        }
        if(node.value < value){
            return find(node.right, value);
        }
        return find(node.left, value);
    }
    public void insert(int value){
        if(root == null){
            root = new Node();
            root.value = value;
        }else{
            insert(root, value);
        }
    }
    public void insert(Node node, int value){
        if(node.value != value){
            if(node.value < value){
                if(node.right == null){
                    node.right = new Node();
                    node.right.value = value;
                }else{
                    insert(node.right, value);
                }
            }else{
                if(node.left == null){
                    node.left = new Node();
                    node.left.value = value;
                }else{
                    insert(node.left, value);
                }
            }
        }
    }
}

public class Main {
     public static void main(String[] args) {
//         HashMapp map = new HashMapp();
//
//         map.push(1, 2);
//         map.push(3, 4);
//         System.out.println("1  " + map.find(1));
//         System.out.println("2  " + map.find(2));
//         map.remove(1);
//         map.push(2, 5);
//         System.out.println("1  " + map.find(1));
//         System.out.println("2  " + map.find(2));
//         System.out.println("3  " + map.find(3));
         Tree tree = new Tree();
         for (int i = 0; i <= 5; i++) {
             tree.insert(i);
         }


    }
}
