package com.pgms.dp;

import java.io.*;
import java.util.*;

class BusyHour {

    static int findBusiestPeriod(int[][] data) {

        int numOfPeople=0;
        int maxNumOfPeople=0;
        int maxTimeStamp=0;

        for(int i=0;i<data.length;i++) {
            if(data[i][2]==1){
                numOfPeople+=data[i][1];
            }
            else{
                numOfPeople-=data[i][1];
            }


            if(i>=data.length-1 || data[i][0]!=data[i+1][0]){
                if(numOfPeople>maxNumOfPeople){
                    maxNumOfPeople=numOfPeople;
                    maxTimeStamp=data[i][0];
                }
            }


        }
        System.out.println("max->"+maxTimeStamp+" ,people->"+maxNumOfPeople);
        return maxTimeStamp;

        // your code goes here

    }


    public static void main(String[] args) {

        List<Integer> prefixNew;

        int[][] arr={
                {1487799425, 14, 1},
                {1487799425, 4,  0},
                {1487799425, 2,  0},
                {1487800378, 10, 1},
                {1487801478, 18, 0},
                {1487801478, 18, 1},
                {1487901013, 1,  0},
                {1487901211, 7,  1},
                {1487901211, 7,  0}
        };

        findBusiestPeriod(arr);
  }

    }

/*

1-> 14
2->






*/