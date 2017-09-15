package com.pgms.sorting;

/**
 * Created by root on 12/7/16.
 */
public class BubbleSort {


    static int [] arr={1,6,2,9,5,7,3,66,100};


    public static void main(String args[]){
        sort(arr);

        System.out.println(arr);
    }

    private static int [] sort(int [] arr) {
        if(arr.length==1){
            return arr;
        }

        boolean isSwapped=true;
        while(isSwapped){
            isSwapped=false;
            for(int i=1;i<=arr.length-1;i++){
                if(arr[i-1]>arr[i]){
                    int temp=arr[i-1];
                    arr[i-1]=arr[i];
                    arr[i]=temp;
                    isSwapped=true;
                }
            }
        }
        return arr;
    }

}
