package com.pgms;

public class Fibanocci {
    
    
    public static void main(String args[]){
        for(int i=0;i<10;i++){
            System.out.println(sum(i));
        }
    }
    
    
    public static  int sum(int i){
        if(i<=1){
            return i;
        }
        else{
            int sum=sum(i-1)+ sum(i-2);
            return sum;
            
        }
        
        
    }
    
    
    
    

}
