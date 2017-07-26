package com.test;

public class OddNumbertest {

    public static void main(String[] args) {

        System.out.println(getOddFreqNumber(new int[]{1,2,3,4,5,6,7,8,6}));

    }

   static  int getOddFreqNumber(int[] array) {
        int oddFreqNumber = 0;
        for (int i=0; i<array.length; i++)
                oddFreqNumber = oddFreqNumber ^ array[i];
        
        return oddFreqNumber;
}
    
    
}
