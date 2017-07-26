package com.pgms.sym;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 1/19/15
 * Time: 6:36 PM
 * To change this template use File | Settings | File Templates.
 */
import java.io.*;
import java.util.Scanner;
     /* Check whether a BST exist for the given Pre Order traversal,
     * Values will start from 1 and will be continuous*/
public class BSTExist {

    static int [] arr={3 ,2 ,1, 5, 4, 6};
    String result=null;

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//        Scanner in = new Scanner(System.in);
//        int totalTestCases = in.nextInt();
//        int NumberOfNodes=0;
//
//
//        for(int i=0;i<totalTestCases;i++){
//            NumberOfNodes=in.nextInt();
//            arr=new int[NumberOfNodes];
//            for(int j=0;j<NumberOfNodes;j++){
//                arr[j]=in.nextInt();
//            }
//            int reachSize=validateNode(0, 0,NumberOfNodes);
//            System.out.println(reachSwwize);
//
//        }


        /* Print YES if there exist a Binary Search Tree for the pree order traversal of the tree*/


        int [] []inp={
                {1 ,2 ,3},
                {2, 1 ,3},
                {3, 2, 1, 5, 4, 6},
                {1 ,3 ,4 ,2},
                {3, 4 ,5 ,1 ,2},
                {3,2,1},
                {1},
                {2,3,1},
                {2,1,3},
                {3,1,4,2},
                {2,3,6,7,4,8,9,5,1},
                {3,2,1,4,6,5},
                {3,2,1,4,5,6},
                {5,1,4,2,6,3},
                {1,2}
        };

        for(int k=0;k<inp.length;k++){
            arr=inp[k];

            String ret1=validateNode(0, 0,arr.length+1)>=arr.length?"YES":"NO";
            boolean ret2= createBSTree(arr,0,arr.length,Integer.MIN_VALUE,Integer.MAX_VALUE);
            String ret= ret2?"YES":"NO";
            System.out.println("-->"+ret1+","+ret);

        }



    }

    private static int validateNode(int index,int min,int max){
        /*
        *   6
            3 2 1 5 4 6
                       3
                     2   5
                   1    4 6
        * */

            if(index<arr.length){  // 3 2 1 5 4 6
                int nodeValue=arr[index];
                if(nodeValue<max && nodeValue>min){
//                    System.out.println(nodeValue);
                    int leftSize=validateNode(index+1,min,nodeValue);
                    int rightSize=validateNode(index+leftSize+1,nodeValue,max);

                    return leftSize+rightSize+1;
                }
                else{
                    return 0;
                }

            }
            return 0;
    }


    private static boolean  createBSTree(int[] arr,int startPos, int endPos, int minValue,int maxValue){


        if(startPos>=endPos){
            return true;
        }

        for(int i=startPos;i<endPos;i++){
            if(arr[i]<=minValue || arr[i]>=maxValue){
                return false;
            }
        }

        int rootVale=arr[startPos];

        int diffPos=startPos+1;

        while(diffPos<endPos && arr[diffPos]<rootVale){
            diffPos++;
        }
        return createBSTree(arr,startPos+1,diffPos,minValue,rootVale) && createBSTree(arr,diffPos,endPos,rootVale,maxValue);

    }




}