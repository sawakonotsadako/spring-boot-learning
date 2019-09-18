package com.yl.demo.learning.algotithm.linkedlist.interview;

public class ReverseALinkedListTest {
    public static void main(String[] args) {
        MyLinkList linkList = new MyLinkList();
        linkList.addNode(1);
        linkList.addNode(2);
        linkList.addNode(3);
        linkList.addNode(4);
        linkList.addNode(5);

        linkList.addNode(5);


        linkList.printList();
        System.out.println("length of linklist:"+linkList.length());

        System.out.println("duplicate times:" + linkList.countDuplicateTimes(5));
        System.out.println("the nth node from the end:" + linkList.getLastNode(7));

        linkList.removeDuplicate();
        linkList.removeNode(6);

        linkList.printList();

        linkList.reverse();

        linkList.printList();



    }
}
