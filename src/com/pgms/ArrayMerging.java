package com.pgms;

public class ArrayMerging {

   static  int[][] a={ 
            {1, 5, 13,29},
            {11,16,25,38},          
            {45,49,52,57},
            {51,54,59,66}
          };

    
    public static void main(String[] args) {
            
       
        int r=0;
        int c=0;
        
        int key=54;
        boolean searchnode=searchnode(0,0,key);
//        System.out.println("searchnode--->"+searchnode);
    }
    /*Given a 2 dimensional array sorted vertically and horizontally, search for an element 
     * and return true if the element is present. (Algorithm, Code and Complexity)*/
   public static boolean searchnode(int r, int c,int key){
       
       if(a[r][c]==key){
           System.out.println("Found");
        System.out.println("r--->"+r+"c--->"+c);
        return true;
       }
       
       if(((c+1)<=3) && a[r][c+1]<=key){
            searchnode(r,c+1,key);
       }
       
       if(((r+1)<=3) && a[r+1][c]<=key){
            searchnode(r+1,c,key);
       }
       
       return false;
   }
    
    
   
    
    
}
