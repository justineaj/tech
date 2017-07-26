package com.pgms;

public class InsertionSorting {
    
    public static void main(String args[]){
        int [] a={3,4,1,7,8,6,9,5,2};
        

        for(int i=1;i<a.length;i++){
            int selected=a[i];
            for(int j=i;j>0;j--){
                if(a[j]<a[j-1]){
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                    
                }
            }
        }
        
        for(int i=0;i<a.length;i++){
            System.out.println(" "+a[i]);
        }
        
    }

}
