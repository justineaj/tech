package com.pgms;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 2/5/16
 * Time: 8:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListAddition {





    public static void main(String args[]){

        ListNode list1=ListNode.createList(new int[]{1,9,9,9});
        ListNode list2=ListNode.createList(new int[]{1,9,9,9});
        ListNode list3=addList(list1, list2,0);
        ListNode.displayList(list3);

    }



    public static ListNode addList (ListNode list1,ListNode list2,int carry){

        if(list1==null && list2==null && carry==0){
            return null;
        }
        int nodeVal=carry;
        if(list1!=null){
            nodeVal+=list1.val;
        }
        if(list2!=null){
            nodeVal+=list2.val;
        }

        ListNode ressultNode=new ListNode(nodeVal%10);
        ressultNode.next= addList(list1!=null?list1.next:null,list2!=null?list2.next:null,nodeVal>9?1:0);
        return ressultNode;


    }


}
