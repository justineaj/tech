package com;

public class RegExText {

    public static void main(String args[]){
//        String str1="abcd gfgsdfg abcd abcd wtwertwer";
//        String str3=str1.replaceAll("[a-z]{1,}\\s+\1", "DUPLICATE");
//        System.out.println(str3);
        
        
        byte b=Byte.parseByte("00000001", 2);
        
        System.out.println(b);
        
        long dest= (b & 0xFFL);
        
        
        
        System.out.println(dest);
        
        
        
    }
    
    
}
