package com.pgms.linkedin;

import java.util.*;

public class WordLadder {

    public static void main(String args[]){

        List<String> wordList=new ArrayList<>();
        wordList.addAll(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
        int ret=new WordLadder().ladderLength("hit","cog",wordList);

        System.out.println(ret);
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> qu=new LinkedList<String>();
        qu.add(beginWord);
        qu.add(null);

        Set<String> visited=new HashSet<String>();
        visited.add(beginWord);

        Set<String> dict=new HashSet<String>();
        for(String s:wordList){
            dict.add(s);
        }


        int len=1;

        while(!qu.isEmpty()){

            String cw=qu.poll();
            if(cw!=null){
                for(int i=0;i<cw.length();i++){
                    char[] chars=cw.toCharArray();

                    for(char c='a';c<='z';c++){
                        chars[i]=c;
                        String wt=new String(chars);
                        if(visited.contains(wt)){
                            continue;
                        }
                        if(dict.contains(wt)){
                            if(endWord.equals(wt)){
                                return len+1;
                            }
                            qu.add(wt);
                            visited.add(wt);
                        }
                    }
                }
            }
            else{
                if(!qu.isEmpty()){
                    qu.add(null);
                }
                len++;
            }
        }
        return 0;
    }
}