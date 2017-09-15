package com.pgms.amzone;

import java.util.Stack;

/**
 * Created by root on 7/18/17.
 */
public class StackPopMin {


    Stack<Integer> nums=new Stack<>();
    Stack<Integer> mins=new Stack<>();


    void push(int n){
        nums.push(n);
        if(mins.size()==0){
            mins.push(n);
        }
        else if(n<mins.peek()){
            mins.push(n);
        }
        else{
            mins.push(mins.peek());
        }
    }

    int pop(){
        mins.pop();
        return nums.pop();

    }

    int popMin(){
        Stack<Integer> temp=new Stack<>();

        while(nums.peek()!=mins.peek()){
            temp.push(nums.pop());
            mins.pop();
        }

        int ret=nums.pop();
        mins.pop();
        while(!temp.empty()){
            this.push(temp.pop());
        }

        return ret;
    }


    int getMin(){
        return mins.peek();
    }

public static void main(String args[]){
    StackPopMin stackPopMin=new StackPopMin();
    stackPopMin.push(8);
    stackPopMin.push(4);
    stackPopMin.push(7);
    stackPopMin.push(4);
    stackPopMin.push(9);
    stackPopMin.push(2);
    stackPopMin.push(10);
    stackPopMin.push(11);


    System.out.println(stackPopMin.getMin());
    System.out.println(stackPopMin.popMin());
    System.out.println(stackPopMin.getMin());



}



}
