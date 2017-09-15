package com.pgms;

public class BinarySearch {
    static int [] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    
    public static void main(String args[]){
       
       int key=12; 
        
       System.out.println(searchRec(key,0,arr.length-1)); ;
       System.out.println(search(key)); 
       
    }
    
    public static int searchRec(int key, int beg,int end){
        
        if(beg>end){
         return -1;    
        }
        int mid=(beg+end)/2;
        
        if(arr[mid]==key){
            return mid;
        }
        
        if(arr[mid]<key){
            return searchRec(key,mid+1,end); 
        }
        else{
            return searchRec(key,beg,end-1); 
        }
    }
    
    
    
    
    public static int  search(int key){
        int beg=0;
        int end=arr.length-1;
        
        while (beg <= end) {
            int mid=(beg+end)/2;
            
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                 beg = mid + 1;
            }
            if (arr[mid] > key) {
                 end = mid - 1;
            }
        }
        return -1;
        
    }
}
