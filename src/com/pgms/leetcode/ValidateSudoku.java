package com.pgms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/9/15
 * Time: 9:25 PM
 * To change this template use File | Settings | File Templates.
 */


public class ValidateSudoku {

    public static void main(String args[]){

        char[][] arr=new char[9][];
        String [] sarr={".87654321",
                        "2........",
                        "3........",
                        "4........",
                        "5........",
                        "6........",
                        "7........",
                        "8........",
                        "9........"};
        int i=0;
        for(String s:sarr){
            arr[i++]=s.toCharArray();
        }


         System.out.println(new ValidateSudoku().isValidSudoku(arr));
    }


    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet=new Set[9];
        Set<Character>[] columnSet=new Set[9];
        Set<Character>[] subMatSet=new Set[9];
        for(int i=0;i<9;i++){
            rowSet[i]=new HashSet<Character>();
            columnSet[i]=new HashSet<Character>();
            subMatSet[i]=new HashSet<Character>();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                Character ch=new Character(board[i][j]);

                int a=(int)((int)i/3)* 3;
                int b=j/3;
                int subMatrixIndex= a+b;
                if(rowSet[i].contains(ch) || columnSet[j].contains(ch)
                        || subMatSet[subMatrixIndex].contains(ch)){

                    return false;
                }
                else{
                    rowSet[i].add(ch);
                    columnSet[j].add(ch);
                    subMatSet[subMatrixIndex].add(ch);
                }
            }
        }
        return true;

    }
}
