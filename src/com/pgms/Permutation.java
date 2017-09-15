package com.pgms;

public class Permutation {
    
    
    public static void main(String[] args) {
        
      char[] str={'a','b','c','d'};  
      permute("",str);
    }
    
    
    
    public static void permute(String s,char[] letters){

        if(letters.length==1){
            System.out.println(s+Character.toString(letters[0]));
        }
        
        for(char c:letters){
            permute(s+Character.toString(c),getRemaining(letters,c));
        }
        
    }
    
    
    private static char[] getRemaining(char[] array,char c){
        
        char[] remaining=new char[array.length-1];
        int i=0;
        for(char temp:array){
            if(c==temp){
                continue;
            }
            remaining[i]=temp;
            i++;
        }
        return remaining;
    }
    

}
