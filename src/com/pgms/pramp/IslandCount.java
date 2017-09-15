package com.pgms.pramp;

/**
 * Created by root on 6/18/17.
 */
public class IslandCount {


    public static void main(String args[]){

        int [][]binaryMatrix = {
                {0,    1,    0,    1,    0},
                {0,    0,    0,    1,    1},
                {1,    0,    0,    1,    0},
                {0,    1,    1,    0,    0},
                {1,    0,    1,    0,    0}
        };



        int islandCount=0;

        boolean[][] visitStatus=new boolean[binaryMatrix.length][binaryMatrix[0].length];

        for(int i=0;i<binaryMatrix.length;i++){
            for(int j=0;j<binaryMatrix[0].length;j++){

                if(isNewIsland(visitStatus,binaryMatrix,i,j)){
                    islandCount++;
                }

            }
        }

        System.out.println(islandCount);

    }

    private static boolean isNewIsland(boolean[][] visitStatus,int[][] binaryMatrix, int i, int j) {


        if(i<0||i>=binaryMatrix.length || j<0|| j>=binaryMatrix[0].length){
            return false;
        }

        if(binaryMatrix[i][j]==0 ||visitStatus[i][j]){
            return false;
        }

        visitStatus[i][j]=true;

        isNewIsland(visitStatus,binaryMatrix,i-1,j);
        isNewIsland(visitStatus,binaryMatrix,i+1,j);
        isNewIsland(visitStatus,binaryMatrix,i,j-1);
        isNewIsland(visitStatus,binaryMatrix,i,j+1);
        return true;



    }


}
