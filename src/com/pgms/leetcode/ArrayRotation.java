package com.pgms.leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 12/18/14
 * Time: 7:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayRotation {

          //TODO incomplete

    public static void main(String args[]){
        int [] arr={0,1,2,3,4,5};
        int k=2;
        System.out.println(Arrays.toString(arr));
        rotate(arr,k);
    }

    static void rotate(int [] arr, int k){

        int pos=0,nextpos=0, temp1,temp2;


        for(int i=0;i<k;i++){
            pos=i;
            temp1=arr[pos];
            do{
                nextpos=(pos+k)%arr.length;
                temp2= arr[nextpos];
                arr[nextpos]=temp1;
                temp1=temp2;

                pos=nextpos;

            }   while(pos!=i);
        }

        System.out.println(Arrays.toString(arr));
    }


}
