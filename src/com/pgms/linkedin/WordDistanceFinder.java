package com.pgms.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* This class will be given a list of words (such as might be tokenized
 * from a paragraph of text), and will provide a method that takes two
 * words and returns the shortest distance (in words) between those two
 * words in the provided text.
 * Example:
 *   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
 *   assert(finder.distance("fox","the") == 3);
 *   assert(finder.distance("quick", "fox") == 1);
 *
 * "quick" appears twice in the input. There are two possible distance values for "quick" and "fox":
 *     (3 - 1) = 2 and (4 - 3) = 1.
 * Since we have to return the shortest distance between the two words we return 1.
 */
public class WordDistanceFinder {
    Map<String,List<Integer>> wordMap=new HashMap<String,List<Integer>>();


    public WordDistanceFinder (List<String> words) {
        for(int i=0;i< words.size();i++){
            List<Integer> list=null;
            String word= words.get(i);
            if(wordMap.get(word)!=null){
                list= wordMap.get(word);
            }
            else{
                list=new ArrayList< Integer>();
                wordMap.put(word, list);
            }
            list.add(i);
        }
    }

    /* O(n^2)*/
    public int distance (String wordOne, String wordTwo) {
        List<Integer> listOne= wordMap.get(wordOne);
        List<Integer> listTwo = wordMap.get(wordTwo);

        int minDistanc=Integer.MAX_VALUE;
        for(Integer w1: listOne){
            for(Integer w2: listTwo){
                if(Math.abs(w1-w2)< minDistanc){
                    minDistanc=Math.abs(w1-w2);
                }
            }
        }

        return minDistanc;

    }


    /* O(n)*/
    public int distance_n (String wordOne, String wordTwo) {
        List<Integer> listOne= wordMap.get(wordOne);
        List<Integer> listTwo = wordMap.get(wordTwo);

        int minDistanc=Integer.MAX_VALUE;
        int i=0,j=0;
        while(i<listOne.size() && j<listTwo.size()){
            int dis=Math.abs(listOne.get(i)-listTwo.get(j));
            if(dis==1){
                return dis;
            }
            if(dis<minDistanc){
                minDistanc=dis;
            }
            if(listOne.get(i)<listTwo.get(j)){
                i++;
            }
            else{
                j++;
            }
        }
        return minDistanc;

    }
}
