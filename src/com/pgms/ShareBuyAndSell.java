package com.pgms;

public class ShareBuyAndSell {
    
    
    /*
     * Share market. Given an price of share in order of day as integer array, find out when 
     * an user can buy n when he/she can sell to gain maximum profit. 

        ex : 30, 12, 15, 10, 40, 30, 60, 100, 
            out put : 10 and 100 
        30, 12, 15, 10, 40, 30, 60, 100, 2, 110, 
            out put : 2, 110 

        30, 12, 15, 5, 40, 30, 60, 130, 2, 110 
            output: 5, 130*/
    
    
    public static void main(String args[]){
        
        getMinAndMax(new int[]{30, 12, 15, 10, 40, 30, 60, 100});//10,100
        getMinAndMax(new int[]{30, 12, 15, 10, 40, 30, 60, 100, 2, 110});//2,110
        getMinAndMax(new int[]{30, 12, 15, 5, 40, 30, 60, 130, 2, 110});//5,130
        getMinAndMax(new int[]{310, 330, 15, 5, 40, 30, 60, 130, 2, 110});//5,130
        getMinAndMax(new int[]{3, 330, 15, 5, 40, 30, 60, 130, 2, 110});//5,130
    }
    
    
    public static void getMinAndMax(int arr[]){
        int minPos=0;
        int maxPos=0;
        int tempMinPos=0;
        int tempMaxPos=0;
        int profit=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[tempMaxPos]){
                tempMaxPos=i;
            }
            if(arr[i]<arr[tempMinPos]){
                tempMinPos=i;
                tempMaxPos=i;
            }
            if(tempMinPos<tempMaxPos && (arr[tempMaxPos]-arr[tempMinPos]>profit)){
                minPos=tempMinPos;
                maxPos=tempMaxPos;
                profit=arr[tempMaxPos]-arr[tempMinPos];
            }
        }
        System.out.println("Min->"+arr[minPos]+" MaxPos->"+arr[maxPos]);
    }
    
    

}
