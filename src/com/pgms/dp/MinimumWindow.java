package com.pgms.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindow {


    public static void main(String []args){
//        String ret=new MinimumWindow().minWindow("bdab","ab");
//        String ret=new MinimumWindow().minWindow("ab","b");
        String ret=new MinimumWindow().minWindow("baaaabab","abb");

        System.out.println(ret);

    }


    public String minWindow(String s, String t) {

        int start=0;
        int end=0;
        String win="";
        int toFind=t.length();
        int minLength=Integer.MAX_VALUE;

        Map<Character,Integer> st=new HashMap<Character,Integer>();
        Map<Character,List<Integer>> pos=new HashMap<Character,List<Integer>>();
        char[] cArray=t.toCharArray();
        for(char c:cArray){
            if(st.get(c)==null){
                st.put(c,1);
            }
            else{
                st.put(c,st.get(c)+1);
            }
        }

        boolean [] flgs=new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            Character tc=s.charAt(i);
            if(st.get(tc)!=null){
                flgs[i]=true;
                end=i+1;

                if(st.get(tc)==0){
                    int temp=start;
                        while(temp<i){
                            if(s.charAt(temp)==s.charAt(i) && flgs[temp]) {
                                flgs[temp]=false;
                                break;
                            }
                            temp++;
                        }
                        while(!flgs[start]) {
                            start++;
                        }

                }
                else{
                    if(st.get(tc)>0){
                        st.put(tc,st.get(tc)-1);
                        toFind--;
                    }
                }
            }
            else if(start==i){
                start++;
            }

            if(toFind<=0 && end-start<= minLength){
                win=s.substring(start,end);
                minLength=end-start;
            }
        }
        return win;




    }
}