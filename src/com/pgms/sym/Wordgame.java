package com.pgms.sym;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 2/24/15
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Wordgame {
    static Set<String> wordMap=new HashSet<String>();
    static{
        wordMap.add("abe");
        wordMap.add("hi3");
        wordMap.add("khif");
        wordMap.add("def2");
        wordMap.add("j");


    }



    static String[][] arr={
            {"a","b","c","1"},
            {"d","e","f","2"},
            {"g","h","i","3"},
            {"j","k","l","4"}
    };

    static class Position{
        Position(int i,int j){
            this.i=i;
            this.j=j;
        }
        public int i;
        public int j;

        @Override
        public boolean equals(Object obj){
            Position p=(Position)obj;
            return i==p.i && j==p.j;

        }
        @Override
        public int hashCode(){
            return 1;
        }
    }


   static  StringBuilder outPut=new StringBuilder();
   static Set<Position> pSet=new HashSet<Position>();

    public static void getWord(int i,int j,int length){
        Position p=new Position(i,j);

        if(i<0|| j<0||i>arr.length-1 || j>arr[0].length-1 || pSet.contains(p)){
            return;
        }

        outPut.append(arr[i][j]);
        pSet.add(p) ;

        if(length==0){
            if(isValid(outPut.toString())) {
            System.out.println(outPut.toString());
            }
        }
        else{
            getWord(i,j+1,length-1);
            getWord(i,j-1,length-1);
            getWord(i+1,j,length-1);
            getWord(i-1,j,length-1);
        }

        outPut.replace(outPut.length()-1,outPut.length(),"");
        pSet.remove(p);
    }


    static boolean isValid(String word){
              return wordMap.contains(word);
    }

    public static void main(String args[]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                 for(int k=0;k<arr.length*arr[i].length;k++){
                     getWord(i,j,k);
                 }
            }
        }
    }
}

