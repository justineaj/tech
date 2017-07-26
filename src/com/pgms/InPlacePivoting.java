package com.pgms;

public class InPlacePivoting {

    /**
     * @param args
     */
    public static void main(String[] args) {
       
        int []arr={51,1,4,88,44,5,67,82,9,42,33,29,16,74,94,74,27,63,93};
        int leftPos=0;
        int rightPos=arr.length-1;
        int pivot=arr[0];
        int element=arr[0];;
        while(leftPos<=rightPos){

                while(arr[rightPos]>pivot){
                    rightPos--;
                }
                
                while(arr[leftPos]<=pivot){
                    leftPos++;
                }
                printArray(arr);
                int temp=arr[leftPos];
                arr[leftPos]=arr[rightPos];
                arr[rightPos]=temp;
        }
        
    }
    private static void printArray(int []arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(","+arr[i]);
            }
        System.out.println();
    }
    
}
