package com.pgms.dp;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Abbreviation {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT 
        w1=abABc
        w2=abc
        */
//        Scanner scan = new Scanner(System.in);
//        int c = scan.nextInt();
        String w1="abABabc";
        String w2="ABC";

//        for(int i=0;i<c;i++){
//            w1=scan.next();
//            w2=scan.next();
//
            System.out.println((canConvert(w1.toCharArray(),w2.toCharArray())?"YES":"NO"));
//        }
    }
    private static boolean canConvert(char[] w1, char[] w2) {
        boolean[][] dp=new boolean[w1.length+1][w2.length+1];

                for(int i = 0; i <= w1.length; i++) {
                    for(int j = 0; j <= w2.length; j++) {
                        dp[i][j] = false;
                    }
                }
                dp[0][0] = true;

                for (int i = 0; i < w1.length; i++){
                    for (int j = 0; j <= w2.length; j++)if (dp[i][j]){
                        if(j < w2.length && Character.toUpperCase(w1[i]) == w2[j]) {
                            dp[i + 1][j + 1] = true;
                        }
                        if(!Character.isUpperCase(w1[i])) {
                            dp[i + 1][j] = true;
                        }
                    }
                }

                return dp[w1.length][w2.length];

        }

}
