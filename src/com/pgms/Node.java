package com.pgms;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 11/4/14
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node{

    public Node(){

    }

    public Node(int id){
        this.id=id;
    }

    int  id;
    Node left;
    Node right;
    Node next;
    @Override
    public String toString() {
        return ""+id;
    }
}