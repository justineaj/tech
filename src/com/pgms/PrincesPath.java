package com.pgms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PrincesPath {
   static  int boti=0,botj=0;
    static int pi=0,pj=0;
static void displayPathtoPrincess(int n, String [][] grid){
    
    
    
        String xdire=(boti-pi)>0?"LEFT":"RIGHT";    
        String ydire=(botj-pj)>0?"DOWN":"UP";    
        int xmove=Math.abs(boti-pi);    
        int ymove=Math.abs(botj-pj);    
         int x=0,y=0;   
        while(x!=xmove || y!=ymove){
            if(x<xmove){
                System.out.println(xdire);
                x++;
            }
           if(y<ymove){
                System.out.println(ydire);
                y++;
            }

        }            

        }
  
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[][] = new String[m][m];
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < m; j++) {
            grid[i][j] = in.next();
            if("m".equals(grid[i][j])){
                boti=i;
                botj=j;
            }
            if("p".equals(grid[i][j])){
                pi=i;pj=j;
            }
        }
    }
    displayPathtoPrincess(m,grid);
    }
}