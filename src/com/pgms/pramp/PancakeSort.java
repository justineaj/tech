package com.pgms.pramp;

import java.util.Arrays;

/**
 * Created by root on 6/17/17.
 */
public class PancakeSort {

public static  void main(String args[]){

    int []arr = {1, 5, 4, 0, 3, 2};

    int maxIndex=0;
    for(int i=arr.length-1;i>0;i--){
        maxIndex=getMaxIndex(arr,i);
        if(maxIndex!=i){
            flip(arr,maxIndex);
            flip(arr,i);
        }
    }

    System.out.println(Arrays.toString(arr));
}

    private static int getMaxIndex(int []arr,int k){
        int maxIndex=0;
        for(int i=0;i<=k;i++){
            if(arr[i]>arr[maxIndex]){
                maxIndex=i;
            }
        }
        return maxIndex;
    }


    private static void flip(int [] arr, int k){
        int i=0;
        int temp=0;
        while(i<k){
            temp=arr[i];
            arr[i]=arr[k];
            arr[k]=temp;
            i++;
            k--;
        }



    }




}
