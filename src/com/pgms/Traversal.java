package com.pgms;

import java.util.Stack;
/*
 *            8
 *           / \  
 *          /    \  
 *         7      10   
 *       /  \     / \    
 *      4    15  1   13
 *       \
 *       23 
 * */
public class Traversal {

    public static void main(String[] args) {
        Node n8=new Node(8);Node n7=new Node(7);
        Node n4=new Node(4);Node n15=new Node(15);
        Node n10=new Node(10);Node n1=new Node(1);
        Node n13=new Node(13);Node n23=new Node(23);
        
        n8.left=n7;n8.right=n10;
        n7.left=n4;n7.right=n15;
        n4.right=n23;n10.left=n1;
        n10.right=n13;
        
//        System.out.println();
//        inorderRecursion(n8);
//        System.out.println();
//        inorder(n8);
           
//        preorderRecursion(n8);
//        preorder(n8);
        
        postOrderRecursion(n8); 
        System.out.println();
        postOrder(n8);
        
    }
    
    private static void postOrderRecursion(Node node){
        if(node==null){
            return;
        }
        postOrderRecursion(node.left);
        postOrderRecursion(node.right);
        System.out.print(","+node.id);
    }
    
    private static void postOrder(Node n){
        Stack<Node> stack=new Stack<Node>();
        stack.push(n);
        Node node;
        while(!stack.isEmpty()){
            node=stack.pop();
            while(node.left!=null){
                stack.push(node.left);
                node=node.left;
            }
            
            if(node.right!=null){
                node=node.right;
                stack.push(node);
            }
            else{
                System.out.print(","+node.id);
                Node popednode=stack.pop();
                if(node.right!=null){
                    stack.push(node);
                    stack.push(node.right);
                    
                }
            }
        }
    }

    public static void preorderRecursion(Node node){
        if(node==null)
            return;
       
        System.out.print(","+node.id);
        preorderRecursion(node.left);
        preorderRecursion(node.right);

    }
    
    private static void preorder(Node node){
        Stack<Node> stack=new Stack<Node>();
        stack.push(node);
        System.out.println();
        while(!stack.empty()){
            Node n=stack.pop();
            System.out.print(","+n.id);
            if(n.right!=null){
                stack.push(n.right);
            }
            if(n.left!=null){
              stack.push(n.left);  
            }
            
        }
    }
      
      
      
    private static void inorderRecursion(Node node){
        if(node==null)
            return;
        inorderRecursion(node.left);
        System.out.print(","+node.id);
        inorderRecursion(node.right);
    }
    
    private static void inorder(Node node){
        
        Stack<Node> stack=new Stack<Node>();
        Node n=node;
        stack.push(n);
        while(!stack.isEmpty()){
            n=stack.pop();
            while(n.left!=null){
                stack.push(n);
                n=n.left;
            }
            System.out.print(","+n.id);
            if(n.right!=null){
                stack.push(n.right);
            }
            else if(!stack.isEmpty()){
                n=stack.pop();
                System.out.print(","+n.id);
                if(n.right!=null){
                    stack.push(n.right);
                }
            }
        }
        
    }
}

