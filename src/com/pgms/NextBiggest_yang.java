package com.pgms;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 4/13/15
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class NextBiggest_yang {
    public int[] myNumber;

    public NextBiggest_yang(int[] input){
        this.myNumber = input;
    }

    public int findIt(){
        System.out.print(Arrays.toString(this.myNumber)+"=>");
        for(int i = this.myNumber.length - 1; i > 0; i--){
            if(i != 0 && this.myNumber[this.myNumber.length - 1] > this.myNumber[i]){

                int tmp = this.myNumber[this.myNumber.length - 1];
                this.myNumber[this.myNumber.length - 1] = this.myNumber[i];
                this.myNumber[i] = tmp;
                int[] needToSort = Arrays.copyOfRange(this.myNumber, i + 1, this.myNumber.length);

                Arrays.sort(needToSort);

                int index = 0;
                for(int j = i + 1; j < this.myNumber.length; j++){
                    this.myNumber[j] = needToSort[index];
                    index++;
                }

                break;
            }
        }

        System.out.println(Arrays.toString(this.myNumber));
        return 0;
    }

    public static void main(String[] args){

        int [][][] arr={
                {new int[]{1,2,3,4},
                new int[]{5,4,6,9},
                new int[]{9,7,2,3,4},
                new int[]{1,1,2,3},
                new int[]{9,8,7,6},
                new int[]{9,6,7,8},
                new int[]{9,7,8,6},
                new int[]{3,6,9,4,2},
                new int[]{2,3},
                new int[]{2,0,0,3},
                new int[]{9,4,7,5},
                new int[]{9,4,7,5,5}}};

        int[] numbers = {4,3,2,4};
        for(int i=0;i<arr[0].length;i++){
            NextBiggest_yang jb = new NextBiggest_yang(arr[0][i]);
            jb.findIt();
        }
         //[9, 7, 8, 6

    }
}
