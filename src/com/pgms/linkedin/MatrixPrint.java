package com.pgms.linkedin;

/**
 * Created by root on 6/20/17.
 */
public class MatrixPrint {

    /*
    *
    * https://www.careercup.com/question?id=5163286157852672
    *
    * Print an NxM matrix with nw-se diagonals starting at bottom left corner. Ex:

    1  2  3  4
    5  6  7  8
    9 10 11 12


The output should be:

    9
    5 10
    1 6 11
    2 7 12
    3 8
    4
* */


    public static void main(String args[]){

        int [][]arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int rStart=arr.length-1;
        int cStart=0;
        int count=arr.length*arr[0].length;

        for(int i=0;i<=count;i++){
            int j=0;
            while((rStart+j)<arr.length && (cStart+j)<arr[0].length){
                System.out.print(arr[rStart+j][cStart+j]+" ");
                j++;
            }
            if(--rStart<0){
                rStart=0;
                cStart++;
            }
            System.out.println();
        }




    }






}
