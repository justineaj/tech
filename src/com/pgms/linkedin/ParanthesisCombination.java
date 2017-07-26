package com.pgms.linkedin;

/**
 * Created by root on 12/26/16.
 */
public class ParanthesisCombination {

    static int maxNum=3;
    static int count=0;

    public static void main(String args[]){
        count=0;
        new ParanthesisCombination().printPran("",0,0,maxNum);
        System.out.println("===============================================================");
        new ParanthesisCombination().paranthesis("",maxNum,maxNum);

        System.out.println(count);
    }


    private void printPran(String out, int open, int close, int pair){

        if(open==pair && close==pair){
//            count++;
            System.out.println(out);
        }
        if(close<open){
            printPran(out+")",open,close+1,pair);
        }
        if(open<pair){
            printPran(out+"(",open+1,close,pair);
        }


    }


    private void paranthesis(String out, int left, int right){
        if(left==0 && right==0){
            System.out.println(out);
            return;
        }

//        if(left==0 || right==0){
//            return;
//        }
        if(left>0 ) {
            out += "(";
            paranthesis(out, left -= 1, right);
        }
         if(right>0 ) {
            out+=")";
            paranthesis(out,left,right-1);
        }


    }





}
