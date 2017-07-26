package com.pgms.oops;

import java.util.*;

/**
 * Created by root on 7/4/17.
 *
 #For given set of Strings
 #String input = {“hello”, “zzzee”, “world”, ”helloo”}

 #Output:
 #Display the words in repetitions-count order, with counts of each letter in the word.
 #Order words with max count first, followed by least count (descending). If count is same then order them by natural order.

 #see below example:

 #zzzee  = z-3, e-2
 #helloo = l-2, o-2, e-1, h-1
 #hello  = l-2, e-1, h-1, o-1
 #world  = d-1, l-1, o-1, r-1, w-1
 *
 */
public class WordSort {



    public static void main(String args[]){
        String [] input = {"hello", "zzzee", "world", "helloo"};

        List<Word> lst=new ArrayList<>();

        for(String str:input){
            Word w=new Word(str);
            lst.add(w);
        }

        Collections.sort(lst, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int i=0;
                while(i<o1.getList().size() && i<o2.getList().size()){
                    if(o2.getList().get(i).getValue()!=o1.getList().get(i).getValue()){
                        return o2.getList().get(i).getValue()-o1.getList().get(i).getValue();
                    }
                    else{
                        i++;
                    }
                }
                return o1.getList().size()-o2.getList().size();
            }
        });


        for(Word w:lst){
                System.out.println(w);
       }



    }



    static class Word{
        String word;
        Map<Character,Integer> mp=new LinkedHashMap<Character,Integer>();
        List<Map.Entry<Character,Integer>> lst=new ArrayList<>();


        Word(String word){
            this.word=word;

            if(word!=null && word.length()>0){
                char[] crs=word.toCharArray();
                for (char c:crs){
                    if(mp.get(c)!=null){
                        mp.put(c,mp.get(c)+1);
                    }
                    else{
                        mp.put(c,1);
                    }
                }

                lst.addAll(mp.entrySet());

                Collections.sort(lst, new Comparator<Map.Entry<Character,Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character,Integer> o1, Map.Entry<Character,Integer> o2) {
                        return !o2.getValue().equals(o1.getValue())?o2.getValue()-o1.getValue():o1.getKey()-o2.getKey();
                    }
                });

            }
        }

        List<Map.Entry<Character,Integer>> getList(){
            return lst;
        }

        @Override
        public String toString() {

            StringBuilder sb=new StringBuilder();
            for(Map.Entry<Character,Integer> e:lst){
                sb.append(e.getKey()+"-"+e.getValue()+",");
            }
            if(sb.length()>0){
                sb.replace(sb.length()-1,sb.length(),"");
            }
            return sb.toString();
        }
    }



}


