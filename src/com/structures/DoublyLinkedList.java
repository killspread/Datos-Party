package com.structures;

public class DoublyLinkedList {
    DoubleNode head;
    int length = 0;

    public int getLength() {
        return this.length;
    }

    public void append(int data) {
        DoubleNode node = new DoubleNode(data);
        if (this.head == null){
            this.head = node;
        }
        else {
            DoubleNode tmp = this.head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            node.setPrev(tmp);
            tmp.setNext(node);
        }
        this.length++;
    }

    public void insert(int data, int i) {
        if (i == this.length) {
            this.append(data);
        }
        else if (i < length && i >= 0) {
            DoubleNode node = new DoubleNode(data);
            if (i == 0) {
                node.setNext(this.head);
                this.head.setPrev(node);
                this.head = node;
            }
            else {
                int count = 0;
                DoubleNode tmp = this.head;
                while (count < i - 1) {
                    tmp = tmp.getNext();
                    count++;
                }
                node.setNext(tmp.getNext());
                tmp.getNext().setPrev(node);
                tmp.setNext(node);
                node.setPrev(tmp);
            }
            this.length++;
        }
        else {
            System.out.println("Invalid index");
        }
    }

    public void delete(int i) {
        if (i >= 0 && i < this.length) {
            if (i == 0) {
                this.head = this.head.getNext();
                this.head.setPrev(null);
            }
            else {
                int count = 0;
                DoubleNode tmp = this.head;
                while (count < i - 1) {
                    tmp = tmp.getNext();
                    count++;
                }
                tmp.setNext(tmp.getNext().getNext());
                if (i != this.length - 1) {
                    tmp.getNext().setPrev(tmp);
                }
            }
            this.length--;
        }
        else {
            System.out.println("Invalid index");
        }
    }

    public int pop(int i) {
        int value;
        if (i >= 0 && i < this.length) {
            if (i == 0) {
                value = this.head.getData();
                this.head = this.head.getNext();
                this.head.setPrev(null);
            }
            else {
                int count = 0;
                DoubleNode tmp = this.head;
                while (count < i - 1) {
                    tmp = tmp.getNext();
                    count++;
                }
                value = tmp.getNext().getData();
                tmp.setNext(tmp.getNext().getNext());
                if (i != this.length - 1) {
                    tmp.getNext().setPrev(tmp);
                }
            }
            this.length--;
        }
        else {
            value = -1;
            System.out.println("Invalid index");
        }
        return value;
    }

    public void printList() {
        StringBuilder list = new StringBuilder("[");
        DoubleNode tmp = this.head;
        while (tmp != null) {
            list.append(tmp.convertToString());
            if (tmp.getNext() != null) {
                list.append(", ");
            }
            tmp = tmp.getNext();
        }
        list.append("]");
        System.out.println(list);
    }

    public void printPrev() {
        StringBuilder list = new StringBuilder("[");
        DoubleNode tmp = this.head.getNext();
        while (tmp != null) {
            list.append(tmp.getPrev().convertToString());
            if (tmp.getNext() != null) {
                list.append(", ");
            }
            tmp = tmp.getNext();
        }
        list.append("]");
        System.out.println(list);
    }
}
