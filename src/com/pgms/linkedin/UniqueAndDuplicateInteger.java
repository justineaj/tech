package com.pgms.linkedin;

/**
 * Created by root on 12/9/16.
 */
public class UniqueAndDuplicateInteger {
    /* TODO

    https://www.careercup.com/question?id=5750859611766784

    * Find unique integers from list of integers
             Write a function that will return an array of integers that occur exactly once in a given array of integers.
            # e.g. For a list [1,2,3,5,2,2,3,4], return [1,5,4] since they appear once (order does not matter).

        Optimize the code if input is sorted.
            # What if the input is sorted, such as [1,2,2,2,3,3,4,5], could the algorithm be further optimized
                # (e.g. space complexity)?
    *
    * PS:Compare with Previous and next
    * */

    /*
    * Given an array of numbers find the duplicates
    * PS: Compare with previous
    *
    * */
//    java.lang.Integer.MAX_VALUE


//    java.util.Arrays.sort(int[])


    public static void main(String args[]){

        int [] arr={1,2,2,2,3,3,4,5};
        int arrSor[]={1,2,2,2,3,3,4,5};


        new UniqueAndDuplicateInteger().removeDuplicate(arrSor);
    }

    private void removeDuplicate(int[] arrSor) {

        if(arrSor.length>1){
            for(int i=0;i<arrSor.length;i++){

                if((i>0 && i<arrSor.length-1 && arrSor[i]!=arrSor[i-1] &&  arrSor[i]!=arrSor[i+1])
                        || (i==0 && arrSor[i]!=arrSor[i+1])
                        || (i==arrSor.length-1 && arrSor[i]!=arrSor[i-1] )){
                    System.out.println(arrSor[i]);
                }
            }

        }


    }


}
