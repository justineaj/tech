package com.recursion;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 9/19/16
 * Time: 12:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class Multiply {

    public static void main(String args[]){
          System.out.println(mul(5,81));

    }



    static int mul(int small,int big){
        if(small==0){
            return 0;
        }
        if(small==1){
            return big;
        }
        int halfSum=  mul(small>>1, big);
        int sum=halfSum+halfSum;
        if(small%2==1){
            sum+=big;
        }
        return sum;
    }
}
