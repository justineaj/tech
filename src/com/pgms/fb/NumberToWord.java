package com.pgms.fb;

/**
 * Created by root on 11/5/16.
 */
public class NumberToWord {

    static String[] ones={"","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
    static String[] teens={"","ELEVEN","TWELVE","THIRTEEN","FOURTEEN","FIFTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN"};
    static String[] tens={"","TEN","TWENTY","THIRTY","FOURTY","FIFTY","SIXTY","SEVENTY","EIGHTY","NINTEY"};
    static String[] powers={"","THOUSAND","MILLION","BILLION","TRILLION"};

    public static void main(String args[]){
        getWord(14);
        getWord(99);
        getWord(90);
        getWord(901);
        getWord(1);
        getWord(143);
        getWord(110);
        getWord(8914);
        getWord(378914);
        getWord(2550);
    }

    static String getWord(int n){
        System.out.println();
        System.out.print("->"+n);
        String word="";
        int pi=0;
        while(n>0){
            word=getSubWord(n%1000)+" "+powers[pi]+word;
            n=(n/1000);
            pi++;
        }
        System.out.print("->"+word);
        return word;
    }

    static String getSubWord(int n){
        String w="";
        w=(n/100)>0?" "+ones[n/100]+" HUNDRED":"";
        n=n%100;
        if(n>10 && n<20){
            w+=(" "+teens[n%10]);
        }
        else{
            w+=(" "+tens[n/10]);
            w+=(" "+ones[n%10]);

        }
        return w;
    }

}


