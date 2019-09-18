package com.yl.demo.learning.algotithm.linkedlist.interview;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyLinkList {
    private Node head = null;

    public void addNode(int data) {

        if (head == null) {
            head = new Node(data);
            return;
        }

        Node pointer = head;
        while(pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new Node(data);

    }

    public void reverse() {

        Node pointer = head;
        Node current, head2 = new Node(-1);
        while(pointer != null) {
            current = pointer;
            pointer = pointer.next;

            current.next = head2.next;
            head2.next = current;
        }

        head = head2;
        head = head.next;
    }

    public void removeNode(int data) {

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node pointer = head;
        Node pre,after;
        while(pointer.next != null) {
            if (pointer.next.data == data) {
                pre = pointer;
                after = pointer.next.next;

                // change the pointer direction
                pre.next = after;
                break;
            }
            pointer = pointer.next;
        }


    }

    public void removeDuplicate() {
        Set<Integer> set = new HashSet<>();
        Node pointer = head;
        Node prev = null;

        while(pointer != null) {

            if (set.contains(pointer.data)) {
                prev.next = pointer.next;
            } else {
                set.add(pointer.data);
                prev = pointer;
            }

            pointer = pointer.next;
        }

    }

    public int getLastNode(int index) {
        int length = this.length();

        if (index > length || index < 0) {
            return -1;
        }
        Node pointer = head;
        int count = this.length() - index;
        for (int i=0; i<count; i++) {
            pointer = pointer.next;
        }
        return pointer.data;
    }

    public int countDuplicateTimes(int data) {
        Map<Integer, Integer> counts = new HashMap<>();

        Node pointer = head;

        while(pointer != null) {
            if (counts.containsKey(pointer.data)) {
                counts.put(pointer.data, counts.get(pointer.data) + 1);
            } else {
                counts.put(pointer.data, 1);
            }
            pointer = pointer.next;
        }

        return counts.get(data);

    }


    public int length() {
        Node pointer = head;
        int count = 0;
        while(pointer != null) {
            count++;
            pointer = pointer.next;
        }
        return count;
    }


    public Node findNode(int data) {

        Node pointer = head;
        while (pointer != null) {
           if (pointer.data == data) {
               break;
           } else {
               pointer = pointer.next;
           }
        }
        return pointer;

    }

    public void printList() {
        Node pointer = head;
        while(pointer != null) {
            System.out.print(pointer.data+"->");
            pointer = pointer.next;
        }
        System.out.println("NIL");
    }

}
