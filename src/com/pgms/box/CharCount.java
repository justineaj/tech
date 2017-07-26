package com.pgms.box;

/**
 * Created by root on 6/14/17.
 */
public class CharCount {

    /* https://www.glassdoor.com/Interview/They-asked-a-question-on-filling-a-binary-tree-They-did-the-outline-Another-one-was-say-you-had-the-following-string-aa-QTN_1971961.htm*/
    public static void main(String args[]){

//            String str="aaabbcbbaac";
        String str="abcdefghij";
            String out="";

            int cc=1;

            for(int i=1;i<=str.length();i++){
                if((i<str.length())&&(str.charAt(i)==str.charAt(i-1))){
                    cc++;
                }
                else{
                    out+=(String.valueOf(str.charAt(i-1)))+cc;
                    cc=1;
                }
            }

            System.out.println(out);



    }

}
