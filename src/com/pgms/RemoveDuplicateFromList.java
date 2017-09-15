package com.pgms;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 11/19/14
 * Time: 10:51 PM
 * To change this template use File | Settings | File Templates.


 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */

public class RemoveDuplicateFromList {

    ListNode n1=new ListNode(1);
    ListNode n2=new ListNode(2);
    ListNode n3=new ListNode(2);

    ListNode n4=new ListNode(3);
    ListNode n5=new ListNode(4);
    ListNode n6=new ListNode(4);
    ListNode n7=new ListNode(5);

    ListNode resultHead;
    ListNode resultPointer;


    public static void main(String args[]){

          new RemoveDuplicateFromList().start();
    }

//Given 1->2->3->3->4->4->5, return 1->2->5
//        Given 1->1->1->2->3, return 2->3

    public ListNode deleteDuplicates(ListNode head) {

        ListNode prev=null;
        ListNode current=head;
        ListNode result=head;

        while(current!=null){

            if(((prev!=null && current.val==prev.val) || (current.next!=null && current.val==current.next.val))){

                prev=current;
                current=current.next;

            }
            else{
                prev=current;
                current=current.next;
                addToResult(prev);
            }
        }

        return  head;
    }


    void addToResult(ListNode n){
       if(resultHead==null){
           resultHead=n;
           resultPointer=n;
       }
        else{
           resultPointer.next=n;
           resultPointer=n;

       }
    }


    public void start(){
        n1.next=n2;
        n2.next=n3;
        n3.next=null;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;

        ListNode res=   deleteDuplicates(n1);
        displayList(resultHead);
    }

    public void displayList(ListNode listNode){
        if(listNode==null){
            return;
        }
        do{
            System.out.print("->"+listNode.val);
            listNode=listNode.next;
        }while(listNode!=null);
    }
}

/*
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) {
*         val = x;
*         next = null;
*     }
* }
*/
