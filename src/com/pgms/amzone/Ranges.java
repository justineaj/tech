package com.pgms.amzone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 9/5/16
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Ranges {

    static List<Integer> ranges=new ArrayList<Integer>();
    static List<Integer> values=new ArrayList<Integer>();
    static int max=0;
    public static void main(String args[]){
        insertRange(1,2,100);
        insertRange(1,2,100);
        insertRange(2,2,100);
        insertRange(5,8,100);
        insertRange(2,3,100);

        System.out.println("-->"+max+"<--");


    }


   static int insertRange(int a,int b,int k){
        int posb=insertRange(b);
       int arrayLength=ranges.size();
        int posa=insertRange(a);

       if(arrayLength!= ranges.size()){
           posb++;
       }

        int i=posa;
        while(i<=(posb)){
            values.set(i,values.get(i)+k);
            if(values.get(i)>max){
                max=values.get(i);
            }
            i++;
        }
        return max;
    }

    static int insertRange(int b){
        if(ranges.size()==0){
            ranges.add(0,b);
            values.add(0,0);
            return 0;
        }

        int pos=0;
        boolean found=false;
        for(int i=0;i<ranges.size();i++){
            if(ranges.get(i)>=b){
                pos=i;
                found=true;
                break;
            }
        }
        if(found){
            if(ranges.get(pos)!=b){
                ranges.add(pos,b);
                values.add(pos,0);
            }
        }
        else{
            pos= ranges.size();
            ranges.add(pos,b);
            values.add(pos,0);
        }

        return pos;
    }

}
