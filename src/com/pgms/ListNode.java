package com.pgms;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 11/20/14
 * Time: 8:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return ""+val;    //To change body of overridden methods use File | Settings | File Templates.
    }


    static  ListNode createList(int [] listArray){
        if(listArray==null || listArray.length==0){
            throw new RuntimeException("Invalid Argument");
        }
        ListNode head=new ListNode(0);
        ListNode result=head;

        for (int i:listArray){
            result.next=new ListNode(i);
            result=result.next;
        }
        return  head.next;

    }

    static void displayList(ListNode list){

        while(list!=null){
            System.out.print(","+list.val);
            list= list.next;
        }

    }

    static ListNode getNodeAt(ListNode head,int n){
        for(int i=0;i<n;i++){
            head=head.next;
            if(head==null){
                return null;
            }
        }
        return head;
    }
}
