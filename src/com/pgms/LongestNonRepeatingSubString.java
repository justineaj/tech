package com.pgms;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingSubString {

    public static void main(String[] args) {
        String str="hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac";
        if(lengthOfLongestSubstring(str)>=0){
            return;
        }
        char[] chars=str.toCharArray();
        int maxlength=0;
        int start=0;
        int subStart=0;
        Set<Character> set=new HashSet<Character>();
        
        for(int i=0;i<chars.length;i++){
            if(!set.contains(chars[i])){
                if((i-start+1)>maxlength){
                    maxlength=i-start+1;
                    subStart=start;
                }
                set.add(chars[i]);
            }
            else{
                while(chars[start]!=chars[i]){
                    set.remove(chars[start]);
                    start++;
                }
                set.add(chars[i]);
                start++;
            }
        }
        
        System.out.println(maxlength);
//        System.out.println(str.substring(subStart,subStart+maxlength));

    }
    
    
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        }
        char[] cs=s.toCharArray();
        Set<Character> setc=new HashSet<Character>();
        int maxlength=0;
        int startPosition=0;
        int substr=0;
        for(int i=0;i<cs.length;i++){
            if(setc.contains(new Character(cs[i]))){
                while(cs[startPosition++]!=cs[i]){
                    setc.remove(new Character(cs[startPosition-1]));
//                     startPosition++;
                }
                setc.add(new Character(cs[i]));
//                 startPosition++;
                
            }
            else{
                if((i-startPosition+1)>maxlength){
                    maxlength=i-startPosition+1;
                    substr=startPosition;
                }
                
               setc.add(new Character(cs[i]));
            }
        }
        System.out.println("startPosition->"+substr+" maxlength->"+maxlength+" ");
        System.out.println(setc);
       return maxlength; 
    }

}

//jivswmdkqtbx