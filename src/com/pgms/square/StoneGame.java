package com.pgms.square;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// The 2-player game of Drawdown is played with N groups of stones. There is a group of stones belonging to player 1 at index 0, a group of stones belonging to
//      player 2 at index N - 1, and groups of stones at indices [1..N-2] that have no specific owner.
// At the start of each game a set of size k containing all valid moves is presented. Moves can be re-used. Each move is represented by an array of N integers,
//      with each integer representing the number of stones at the corresponding position the move adds or removes from the collection.
//      All moves are guaranteed to reduce the total number of stones, even though they may increase the number of stones within an individual group.
// After no more moves can be completed (i.e. there are not enough of the required types of stones to remove to complete any move), the player with the greater
//      number of their own stones remaining is declared the victor. If both players have the same number of stones, then player 2 wins to compensate for the
//      disadvantage of going second.

// Example: Let's say the game begins with a board of [6, 4, 2, 4]. These are the available moves provided:
// 1. [-2, -2, 1, 0]
// 2. [-4, -4, 0 ,0]
// 3. [0, 0, -2, -2]

// Initial board: [6, 4, 2, 4]
// Player 1 performs move 1. New board: [4, 2, 3, 4]
// Player 2 can either perform move 1 or move 3. They decide to perform move 1. New board: [2, 0, 4, 4]
// Player 1 performs move 3 (which is the only move available). New board: [2, 0, 2, 2]
// Player 2 is now forced to perform move 3. New board: [2, 0, 0, 0]
// The game is now over and player 1 is the winner.

enum  PLAYER {PLAYER1, PLAYER2}

public class StoneGame{


    static int player1Count=0;
    static int player2Count=0;

    public static void main(String args[]){

        int [] board={6, 4, 2, 4};

        int [][] moves={
                {-2, -2, 1, 0},
                {-4, -4, 0 ,0},
                {0, 0, -2, -2}
        };

        int [] tempBoard=copyArray(board);

        for(int i=0;i<moves.length;i++){
            move(copyArray(board),moves,i,"");
        }

        // PLAYER winner=getWinner(board);

        System.out.println(player1Count);
        System.out.println(player2Count);


    }

    private static int [] copyArray(int [] board){

        int [] tempBoard=new int[board.length];
        for(int i=0;i<board.length;i++){
            tempBoard[i]=board[i];
        }

        return tempBoard;

    }

    private static boolean canMove(int [] board, int [] move){
        for(int i=0;i<move.length;i++){
            if(board[i]+move[i]<0){
                return false;
            }
        }
        return true;
    }


    static boolean  move(int [] board, int [][] moves, int index,String path){

        if(canMove(board,moves[index])){
            System.out.println();
            printBoard(board);
            System.out.print("--->");
            printBoard(moves[index]);

            for(int i=0;i<moves[index].length;i++){
                board[i]+=moves[index][i];

            }
            path=path+"-" + (index + 1);
        }
        else{
            return false;
        }

        boolean nextPossible=false;
        for(int i=0;i<moves.length;i++){
            nextPossible=move(copyArray(board), moves, i, path)?true:nextPossible;
        }
        if(!nextPossible){
            if(getWinner(board)==PLAYER.PLAYER1){
                player1Count++;
                System.out.println("PLAYER1->"+path);
            }
            else{
                player2Count++;
                System.out.println("PLAYER2->"+path);
            }
            return true;
        }

        return true;
    }


    static void printBoard(int []board){
        for(int i=0;i<board.length;i++){
            System.out.print(board[i]+",");

        }
    }



    static  PLAYER getWinner(int [] board){

        if(board[0]> board[board.length-1] ){
            return PLAYER.PLAYER1;
        }
        else{
            return PLAYER.PLAYER2;
        }

    }

}


