package com.pgms;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/21/15
 * Time: 7:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveDuplicateFromStringArray {


    public static void main(String args[]){
        char[] str={'a','a','d','d','b','a','a','a','c','a'};
        int len=str.length;
        int temp=1;
        int max=1;

        for(int i=1;i<len;i++){
            int j=0;
            for(j=0;j<max;j++){
                if(str[j]==str[i]){
                   break;
                }
            }
            if(str[j]==str[i]){
                str[i]='-';
            }
            else{
                str[max]=str[i];
                str[i]='-';
                max++;
            }


        }
        System.out.print(Arrays.toString(str));;

    }

}
