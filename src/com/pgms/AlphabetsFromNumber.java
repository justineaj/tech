package com.pgms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 11/15/14
 * Time: 10:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class AlphabetsFromNumber {

   static  List<String> dis=new ArrayList<String>();

    static String num="321";
    static Map<String,String> alphabets=new HashMap<String,String>();





    public static void main(String args[]){

        for(int i=1;i<=26;i++){
         alphabets.put("" + i, String.valueOf((char) (i + 64)));
        }

        findAlphabet(0);
    }

    static void findAlphabet(int position){

        if(position>num.length()){
            return;
        }
        else if(position==num.length()){
            System.out.println(getDisplayString(dis));
            return;
        }

        if(alphabets.get(num.substring(position,position+1))!=null){
            dis.add(alphabets.get(num.substring(position,position+1)));
            findAlphabet(position + 1);
            dis.remove(dis.size()-1);
        }


        if((position+2) <=num.length() && alphabets.get(num.substring(position,position+2))!=null ){
            dis.add(alphabets.get(num.substring(position,position+2)));
            findAlphabet(position+2);
            dis.remove(dis.size()-1);
        }
    }

    static String getDisplayString(List<String> dis){
        StringBuilder sb=new StringBuilder();
        for(String s:dis){
            sb.append(s);
        }
        return sb.toString();
    }


}
