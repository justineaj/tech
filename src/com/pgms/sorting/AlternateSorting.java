package com.pgms.sorting;

import java.util.Arrays;

/**
 * Created by root on 4/7/17.
 */
public class AlternateSorting {


    static int arr[] ={0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


    public static void main(String args[]){

        for(int i=0;i<arr.length;i++){
            for(int j=arr.length-1;j>i;j--){

                if(arr[symloc(j)]>arr[symloc(j-1)]){
                    int temp=arr[symloc(j)];
                    arr[symloc(j)]=arr[symloc(j-1)];
                    arr[symloc(j-1)]=temp;
                }
            }
        }
System.out.print(Arrays.toString(arr));
    }

    public static int symloc(int pos){
        int maxlength=arr.length;
        pos=pos*2;
        if(pos>(maxlength-1)){
            pos=(maxlength-1)-(pos%maxlength);
        }
        return pos;
    }

}
