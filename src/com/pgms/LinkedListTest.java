package com.pgms;

public class LinkedListTest {
    static Node root=null;
    public static void main(String[] args) {
        
        int a[]={4,5,7,3,2,9,6,8};
        for(int n:a){
            Node node=new Node();
            node.id=n;
            if(root!=null){
               node.next=root;
               root=node;
            }
            else{
                root=node;
            }
        }
        displayLinkedList(root);
//        reverseListIterate(root);
//        reverseListRecursion(root);
        reverseListIterateWhile(root);
        displayLinkedList(root);
        

    }
    
    
    public static Node reverseListRecursion(Node node){
        if(node.next==null){
            root=node;
            return node;
        }
        Node reversedNodeTail=reverseListRecursion(node.next);
        node.next.next=node;
        node.next=null;
        return node;
        
    }
    
    public static void  reverseListIterateWhile(Node n){
        
        Node next=n.next;
        Node previous=null;
        while(n!=null){
            n.next=previous;
            previous=n;
            n=next;
            if(n!=null){
            next=n.next;
            }
        }
        root=previous;
    }
    
    
    public static void  reverseListIterate(Node n){
        Node previous=null;
        Node next=n.next;
        Node current=n;
        
        do{
            current.next=previous;
            previous=current;
            current=next;
            if(next!=null){
                next=next.next;
                current.next=previous;
            }
        }while(next!=null);
        root=current;
    }
    
    
    public static void displayLinkedList(Node n){
        while(n!=null){
            System.out.print(n.id+" , ");
            n=n.next;
        }
        System.out.println("");
        
    }

}


//class Node{
//    public int id;
//    public Node next;
//}
