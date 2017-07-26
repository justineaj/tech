package com.pgms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 4/19/15
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 *
 * Split teh String into words of maximum length (maxLength). But the words should not be partial
 */
public class SplitStringByLength {

    public static void main(String args[]){

        String input="The red brown fox juump over teh young lady a q cbn";
        int maxLength=8;
        String [] inpArray=input.split(" ");
        List<String> result=new ArrayList();
        String temp=inpArray[0];
        for(int i=1;i<inpArray.length;i++){
            if( (temp+" "+inpArray[i]).length()>maxLength){
                result.add(temp+" ");
                temp=inpArray[i];
            }
            else{
                temp+=(" "+inpArray[i]);
            }
        }
        result.add(temp);
        for(String s:result){
            System.out.println(s);
        }
    }
}
