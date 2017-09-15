package com.pgms.box;

/**
 * Created by root on 6/16/17.
 */


/*
4* -> 1

   4*
  4 4    -> 1


         3
      4      5*    -> 3
    4* 7*
   4 4


    4
  4*   5   -> 3
 4 4 6* 7*
4 4


* */

public class UnivalTrees {


    // Java program to find count of single valued subtrees

    /* Class containing left and right child of current
     node and key value*/
    static class Node{
        int data;
        Node left, right;

        public Node(int item){
            data = item;
            left = right = null;
        }
    }

public static void main(String args[]){

    System.out.println(traverse(getTree1()));
    System.out.println(traverse(getTree2()));

}





    public static int traverse(Node n){
        if(n==null){
            return 0;
        }

        int leftRet=0;
        int rightRet=0;

        leftRet=traverse(n.left);
        rightRet=traverse(n.right);

        if(leftRet==0 && rightRet==0){
            return 1;
        }

        if(leftRet==1 && rightRet==1){
            if((n.left==null || n.left.data==n.data) && (n.right==null || n.right.data==n.data)){
                return 1;
            }
        }


        return leftRet+rightRet;

    }



    private static Node getTree1(){

         /* Let us construct the below tree
                5
              /   \
            4      5
          /  \      \
         4    4      5 */

        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(4);
        root.right.right = new Node(5);
        return root;
    }


    private static Node getTree2(){

         /* Let us construct the below tree
               3
            4     5*    -> 3
          4    7*
        4   4

    */

        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.left.left = new Node(4);
        root.left.left.right = new Node(4);
        return root;
    }



//    private Node getTree1(){
//
//         /* Let us construct the below tree
//                5
//              /   \
//            4      5
//          /  \      \
//         4    4      5 */
//
//        Node root = new Node(5);
//        root.left = new Node(4);
//        root.right = new Node(5);
//        root.left.left = new Node(4);
//        root.left.right = new Node(4);
//        root.right.right = new Node(5);
//        return root;
//    }
//




}
