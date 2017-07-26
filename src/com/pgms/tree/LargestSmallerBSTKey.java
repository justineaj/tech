package com.pgms.tree;

/**
 * Created by root on 6/25/17.
 */


import java.io.*;
import java.util.*;

/***********************************************************
 * CODE INSTRUCTIONS:                                      *
 * 1) The method findLargestSmallerKey you're              *
 *    asked to implement is located at line 36.            *
 * 2) Use the helper code below to implement it.           *
 * 3) In a nutshell, the helper code allows you to         *
 *    to build a Binary Search Tree.                       *
 * 4) Jump to line 82 to see an example for how the        *
 *    helper code is used to test findLargestSmallerKey.   *
 ***********************************************************/


class LargestSmallerBSTKey {

    static class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        Node(int key) {
            this.val = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    static class BinarySearchTree {

        Node root;

        int findLargestSmallerKey(Node node,int key) {

            if(node==null){
                return -1;
            }

            if(node.val<key){
	            return Math.max(node.val,findLargestSmallerKey(node.right,key));
            }
            else{
                return findLargestSmallerKey(node.left,key);
            }


        }

        private int findLargestSmallerKey(int num){

            return findLargestSmallerKey(root,num);


        }

        //  inserts a new node with the given number in the
        //  correct place in the tree
        void insert(int val) {

            // 1) If the tree is empty, create the root
            if(this.root == null) {
                this.root = new Node(val);
                return;
            }

            // 2) Otherwise, create a node with the key
            //    and traverse down the tree to find where to
            //    to insert the new node
            Node currentNode = this.root;
            Node newNode = new Node(val);

            while(currentNode != null) {
                if(val < currentNode.val) {
                    if(currentNode.left == null) {
                        currentNode.left = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if(currentNode.right == null) {
                        currentNode.right = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    /*********************************************
     * Driver program to test above function     *
     *********************************************/

    public static void main(String[] args) {

        // Create a Binary Search Tree
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(9);
        bst.insert(25);
        bst.insert(5);
        bst.insert(12);
        bst.insert(11);
        bst.insert(14);

        int result = bst.findLargestSmallerKey(17);
        System.out.println("Largest smaller number is " + result);

    }
}