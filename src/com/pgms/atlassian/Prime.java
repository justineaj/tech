package com.pgms.atlassian;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 7/11/17.
 */
public class Prime {


    static List<Integer> primes=new ArrayList<>();

    public static void main(String args[]){

        int count=0;
        int n=2;

        while(count<20){

            if(isPrime(n)){
                System.out.println(n);
                primes.add(n);
                count++;
            }

            n++;
        }
    }

    private static boolean isPrime(int n) {
        for(int i=0;i<primes.size();i++){
            if(n%primes.get(i)==0){
                return false;
            }
        }
        return true;
    }


}
