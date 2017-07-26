package com.pgms;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 2/7/16
 * Time: 10:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class CircularLinkedListMeetingPoint {

    public static void main(String args[]){
        /* create Circular Linked List */
        ListNode list=ListNode.createList(new int[]{0,1,2,3,4,5,6,7,8,9});
        ListNode lastNode=ListNode.getNodeAt(list,9);

        ListNode midNode=ListNode.getNodeAt(list,7);
        lastNode.next=midNode;

        ListNode beginning=getJoiningNode(list);
        ListNode tmphead=list;
        while(true){
            if(beginning==tmphead){
                System.out.println(" Meeting Point"+tmphead.val);
                return;
            }
            beginning=beginning.next;
            tmphead=tmphead.next;

        }

    }


    public static ListNode getJoiningNode(ListNode list){
        ListNode list2=list;
        while(true){
            list=list.next;
            list2=list2.next.next;
            if(list==null || list2==null){
                System.out.println(" Not a circular linked List");
            }
            if(list==list2){
                System.out.println(" Circular linked List, Node is ");
                return list;
            }
        }

    }
}
