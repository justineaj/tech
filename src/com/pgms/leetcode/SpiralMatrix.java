package com.pgms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String args[]){
         new SpiralMatrix().spiralOrder(new int[][]{{1,2},{3,4}});
    }


    public List<Integer> spiralOrder(int[][] matrix)  {
        List<Integer> list=new ArrayList<Integer>();
        if(matrix==null || matrix.length==0){
            return list;
        }

        int m=matrix.length;
        int n=matrix[0].length;
        int k=0;
        int i=0,i_inc=0,i_min=0,i_max=m;
        int j=0,j_inc=1,j_min=0,j_max=n;

        while(k<=(m*n+1)){
            System.out.print(".");

            if(i>=0 && i<m && j>=0 && j<n){
                list.add(matrix[i][j]);
            }



            if(j_inc==1 && i_inc==0 && j>=j_max){
                j_max--;
                j--;
                j_inc=0;
                i_inc=1;
            }
            else if(j_inc==0 && i_inc==1 && i>=i_max){
                i_max--;
                i--;
                i_inc=0;
                j_inc=-1;
            }
            else if(j_inc==-1 && i_inc==0 && j<=j_min){
                j_min++;
                j++;
                i_inc=-1;
                j_inc=0;
            }
            else if(j_inc==0 && i_inc==-1 && i<=i_min){
                i_min++;
                i++;
                i_inc=0;
                j_inc=1;
            }

            i+=i_inc;
            j+=j_inc;
            k++;

        }

        return list;

}
}
