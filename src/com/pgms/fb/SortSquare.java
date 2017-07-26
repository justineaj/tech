package com.pgms.fb;

import java.util.Arrays;

/**
 * Created by root on 11/7/16.
 */
public class SortSquare {

    /*
    * https://www.careercup.com/question?id=5681516425248768
    *   Given: sorted array of integers
        Return: sorted array of squares of those integers
        Ex: [1,3,5] -> [1,9,25]
    */

    public static void main(String args[]){

        int [] arr={-13,-7,-3,1,2,5,10};
        int [] res=new int[arr.length];
        int l=0,r=arr.length-1,i=0;
        while(l<=r){
            if(Math.abs(arr[l])>Math.abs(arr[r])){
                res[i]=arr[l]*arr[l];
                l++;
            }
            else{
                res[i]=arr[r]*arr[r];
                r--;
            }
            i++;
        }
        for(i=res.length-1;i>=0;i--){
            System.out.print(","+res[i]);
        }

    }



}
