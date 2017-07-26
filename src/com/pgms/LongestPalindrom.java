package com.pgms;

public class LongestPalindrom {

    static int plength=0;
    static int position=0;
    
    public String longestPalindrome(String s) {
        char[] str="aaabaaaa".toCharArray();  // ""
        for(int i=0;i<str.length-1;i++){
            checkforPalindrom(str,0,str.length-i);
            checkforPalindrom(str,i,str.length);
        }
        return new String(str,position,plength+1); 
    }
    
    public static void main(String[] args) {
        System.out.println(new LongestPalindrom().longestPalindrome(null));
       
    }
    
    private  void checkforPalindrom(char[] str,int start,int end){
//        System.out.println(new String(str,start,end-start));
//        if("malayalam".equals(new String(str,start,end-start))){
//            System.out.println("");
//        }
        int k=0;
        int leftPos=(start+end)/2-1;
        int rightPos=((end-start)%2==0?leftPos+1:leftPos+2);
        while((leftPos-k)>=0 &&(rightPos+k)<str.length && str[leftPos-k]==str[rightPos+k]){
            k++;
        }
        if((rightPos-leftPos+2*(k-1))>plength){
            plength=rightPos-leftPos+2*(k-1);
            position=leftPos-k+1;
        }
    }
    
   
    
    
    

}
