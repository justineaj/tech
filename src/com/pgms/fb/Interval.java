package com.pgms.fb;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/28/16
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Interval {
    /*
    * https://www.careercup.com/question?id=5707346257903616
    *
    * # There's a room with a TV and people are coming in and out to watch it. The TV is on only when there's at least a person in the room.
For each person that comes in, we record the start and end time. We want to know for how long the TV has been on. In other words:
Given a list of arrays of time intervals, write a function that calculates the total amount of time covered by the intervals.
For example:

input = [(1,4), (2,3)]  > 3
input = [(4,6), (1,2)]  > 3
input = [(1,4), (6,8), (2,4), (7,9), (10, 15)]  > 11
    * */

    static int [][][] arr={
                    {{1,2},
                     {4,3}},

                    {{4,1},
                     {6,2}},

                    {{1,6,2,7,10},
                     {4,8,4,9,15}}

                    };

    public static void main(String args[]){

        for(int i=0;i<arr.length;i++){
            int [][] interwals=arr[i];
            for(int j=0;j<interwals[0].length-1;j++){
                for(int k=j+1;k<interwals[0].length;k++){
                    if(interwals[0][k]<interwals[0][j]){
                        int t=interwals[0][k];
                        interwals[0][k]=interwals[0][j];
                        interwals[0][j]=t;
                        t=interwals[1][k];
                        interwals[1][k]=interwals[1][j];
                        interwals[1][j]=t;
                    }
                }
            }

            Stack<int[]> st=new Stack<int[]>();
            for(int j=0;j<interwals[0].length;j++){
                if(!st.isEmpty()&& st.peek()!=null && st.peek()[1]>=interwals[0][j]){
                    st.peek()[0]=Math.min(st.peek()[0],interwals[0][j]);
                    st.peek()[1]=Math.max(st.peek()[1],interwals[1][j]);
                }
                else{
                    st.push(new int[]{interwals[0][j],interwals[1][j]});
                }


            }

            while(!st.isEmpty()){
                int [] ar=st.pop();
                System.out.print("("+ar[0]+","+ar[1]+")");
            }
            System.out.println();



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


}
