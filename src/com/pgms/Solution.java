package com.pgms;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isIsomorphic(String s, String t) {

        if(s==null || t==null){
            return s==t;
        }
        Map<Character,Character> mp=new HashMap<Character,Character>();
        return isIso(s.toCharArray(),t.toCharArray(),0,mp);

    }

    private boolean isIso(char [] s, char[] t, int i,Map<Character,Character> mp){
        if(i>=s.length){
            return true;
        }
        if(s[i]==t[i]){
            return isIso(s,t,i+1,mp);
        }
        else{
            if(mp.get(s[i])!=null){
                return t[i]!=mp.get(s[i]);
            }
            else{
                mp.put(s[i],t[i]);
                return isIso(s,t,i+1,mp);
            }
        }
    }
}