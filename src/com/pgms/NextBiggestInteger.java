package com.pgms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 4/10/15
 * Time: 5:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class NextBiggestInteger {

    static int [] arr={1234, 5469, 97234, 1123,9876,9678, 9786, 36942,23,2003, 9475,94755,1243,615243};
    static Map<Integer,Integer> list=new HashMap();

    public static void main(String args[]){
            for(int k=0;k<arr.length;k++){
                nextBiggest(arr[k]);
                list.clear();
            }
    }

private static void nextBiggest(int input){
    int num=input;
    int perviousDigit=0;
    int digit=num%10;
    while((num>0 && digit>=perviousDigit)){

        perviousDigit= digit;
        digit=num%10;

        num=num/10;
        int count=0;
        if(list.get(digit)!=null){
            count= list.get(digit);
        }
        list.put(digit,++count);
    }
    if(num==0){
            System.out.println(input+"=>"+input);
        return;
    }
    for(int l=digit+1;l<=9;l++){
        if(list.get(l)!=null && list.get(l)>0 ){
            num=num*10+l;
            list.put(l,list.get(l)-1);
            break;
        }
    }

    for(int i=0;i<=9;i++){
        if(list.get(i)!=null  && list.get(i)>0){
        for(int j=0;j<list.get(i);j++){
            num=num*10+i;
        }
        }
    }
        System.out.println(input+"=>"+num);
    }

}