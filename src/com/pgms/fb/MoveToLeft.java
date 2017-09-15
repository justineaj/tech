package com.pgms.fb;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/20/16
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class MoveToLeft {


    public static void main(String args[]){

        int[] arr={0,1,0,0,1,2,7,3,0};

        System.out.println(moveToleft(arr));
        System.out.println(Arrays.toString(arr));

    }



    private static int moveToleft(int[] arr){
        int posNonZero=arr.length-1;
        int posZero=0;
        int count=0;
        while(posZero<posNonZero){


            while(posZero<posNonZero && arr[posZero]!=0){
                posZero++;

            }

            while(posZero<posNonZero&& arr[posNonZero]==0){
                posNonZero--;
            }


            if(posZero<posNonZero){
                int temp=arr[posNonZero];
                arr[posNonZero]=arr[posZero];
                arr[posZero]=temp;
                count++;
                posNonZero--;
                posZero++;

            }

        }

        System.out.println("Total writes->"+count);
           return posNonZero+1;

    }






}
