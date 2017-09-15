package com.pgms.linkedin;

import java.util.Stack;

/**
 * Created by root on 12/13/16.
 * If you can hop 1, 2, or 3 steps at a time, calculate the total number of possible combinations for `n` steps.
 * https://www.careercup.com/question?id=5642960319283200
 */
public class NumberOfCombination {

    public static int n=4;
    public static StringBuilder sb=new StringBuilder();

    public static void main(String args[]){
        new NumberOfCombination().move(1);

    }

    public void move(int i){
        String s=i+"-";
        sb.append(s);
        if(i>n){
            sb.replace(sb.indexOf(s),sb.indexOf(s)+s.length(),"");
            return;
        }
        if(n==i){
            System.out.println(sb.toString());
            sb.replace(sb.indexOf(s),sb.indexOf(s)+s.length(),"");
            return;
        }

        move(i+1);
        move(i+2);
        move(i+3);
        sb.replace(sb.indexOf(s),sb.indexOf(s)+s.length(),"");
    }

}
