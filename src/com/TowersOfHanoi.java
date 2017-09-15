package com;

public class TowersOfHanoi {

    public static void main(String[] args) {
        move(4,1,2);

    }
    
    
    public static void move(int numberOfDisks,int origin,int destination){
        if(numberOfDisks==1){
            System.out.println("Move from "+origin+ "to "+ destination);
            return;
        }
        move(numberOfDisks-1,origin,6-(origin+destination));
        move(1,origin,destination);
        move(numberOfDisks-1,6-(origin+destination),destination);
        
    }
    
    

}
