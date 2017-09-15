package com.pgms.apple;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 9/16/16
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class InputNumberCombination {


    static String input="12342123";
    static String output="";
    static int maxlength=input.length();


    public static void main(String args[]){

        move(0,1);
    }


    static void move(int index, int length){

        if(index>=maxlength){
            System.out.println(output);
        }
        else{
            String str=input.substring(index,index+1);
            String s=","+str;
            output+=(s);
            move(index+1,1);
            output=output.substring(0,output.lastIndexOf(s));

            if(index+2<=maxlength){
                str=input.substring(index,index+2);
                if(Integer.parseInt(str)<=26){
                    s=","+str;
                    output+=(s);
                    move(index+2,1);
                    output=output.substring(0,output.lastIndexOf(s));

                }

            }




        }




    }



}
