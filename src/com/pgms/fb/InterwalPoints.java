package com.pgms.fb;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by root on 11/5/16.
 */


/* set of intervals, return smallest number of points cover all of them */
public class InterwalPoints {

    public static void main(String args[]){

//        Iw[] interwals={new Iw(2,4),new Iw(5,7),new Iw(4,6)};
//        Iw[] interwals={new Iw(2,4),new Iw(5,5),new Iw(4,6)};
        Iw[] interwals={new Iw(2,4),new Iw(4,4),};


        if(interwals.length<=0){
            return;
        }

        Arrays.sort(interwals, new Comparator<Iw>() {
            @Override
            public int compare(Iw o1, Iw o2) {
                return o1.end-o2.end;
            }
        });

       int curPosition=interwals[0].end;
        System.out.println(curPosition);
       for(int i=0;i<interwals.length;i++){
            if(interwals[i].start<=curPosition){
                continue;
            }
            else{
                System.out.println(interwals[i].end);
                curPosition=interwals[i].end;
            }
       }

    }


}

class Iw{
    public int start;
    public int end;

    public Iw(int start,int end){
        this.start=start;
        this.end=end;
    }
}
