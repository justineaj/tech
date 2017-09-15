package com.pgms.dp;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by root on 6/21/17.
 */
public class newFibanacci {


    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int t1 = scan.nextInt();
        int t2 = scan.nextInt();
        int n = scan.nextInt();

        BigInteger[] mat = new BigInteger[n];
        for (int j = 0; j < n; j++) {
            mat[j] = new BigInteger("-1");
        }
        mat[0] = new BigInteger(String.valueOf(t1));
        mat[1] = new BigInteger(String.valueOf(t2));
        BigInteger ret = getFib(n - 1, mat);

        System.out.println(ret.toString());

    }

    private static BigInteger getFib(int n, BigInteger[] mat) {
        if (!mat[n].equals(new BigInteger("-1"))) {
            return mat[n];
        }

        mat[n] = getFib(n - 2, mat).add(getFib(n - 1, mat).multiply(getFib(n - 1, mat)));

        return mat[n];

    }
}