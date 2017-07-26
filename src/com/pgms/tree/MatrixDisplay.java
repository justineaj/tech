package com.pgms.tree;

/**
 * Created by root on 6/26/17.
 */
class MatrixDisplay {

    static int[] spiralCopy(int[][] inputMatrix) {
        // your code goes here

        int n=inputMatrix.length-1;
        int m=inputMatrix[0].length-1;

        int[] ret=new int[(m+1)*(n+1)];

        int max=(n+1)*(m+1);
        int count=0;

        int level=0;

        while(count < max){
            int i=0;

            for(i=level;i<=m-level;i++){
                ret[count++]=inputMatrix[level][i];
            }

            for(i=level+1;i<=n-level;i++){
                ret[count++]=inputMatrix[i][m-level];
            }

            for( i=m-level-1;i>=0+level;i--){
                ret[count++]=inputMatrix[n-level][i];
            }

            for(i=n-level-1;i>0+level;i--){
                ret[count++]=inputMatrix[i][level];
            }

            level++;

        }

        return ret;



    }

    public static void main(String[] args) {

        int [][] inputMatrix=
                      { {1,    2,   3,  4,    5},
                        {6,    7,   8,  9,   10},
                        {11,  12,  13,  14,  15},
                        {16,  17,  18,  19,  20}
                };

        int [] ret= spiralCopy(inputMatrix);

        for(int k=0;k<ret.length;k++){
            System.out.print(ret[k]+",");
        }


    }

}