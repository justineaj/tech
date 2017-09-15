package com.test;

/**
 * 
 * @author justine
 *
 */
public class AdaptiveTest {

    public static void main(String[] args) {

//        System.out.println(closeTo(100,300));
//        System.out.println(closeTo(1100,850));
//        System.out.println(closeTo(1001,999));
//
//        System.out.println(multiplyCharacter("Justine"));
//        System.out.println(multiplyCharacter("aabbcc"));
//        System.out.println(multiplyCharacter("test"));

//        System.out.println(canDevide(new int[]{6,1,2,5,3,4,7}));  //Sum=14
        System.out.println(canDevide(new int[]{2,2,6,3,1})); //
//        System.out.println(canDevide(new int[]{2,2,6,1,2,5,3,4,7,4}));//Sum=18
        
//        System.out.println(insertCharacter("justine"));
//        System.out.println(insertCharacter("aabbcc"));
//        System.out.println(insertCharacter("test"));
        
        
    }
    
    /* Problem 1
     * Write a method which given two integers, returns the integer that is closest to 1000. */
    public static int closeTo(int a, int b){
        return Math.abs(1000-a)<Math.abs(1000-b)?a:b;
    }
    
    /*Problem 2
     * Write a method which given a string, returns a string where every character in the original is doubled.
     *  For example, given the string "xyz", return the string "xxyyzz".*/
    
    public static String multiplyCharacter(String input){
        if(input==null){
            return null;
        }
        StringBuilder sb=new StringBuilder();
        for(char c:input.toCharArray()){
            sb.append(c).append(c);
        }
        return sb.toString();
    }
    
    /* Problem 3
     * Write a method which takes an array of integers.  The method should return true if there is a way to split 
     * the array in two so that the sum of the numbers on one side of the split equals the sum of the numbers on the other side. */
    
    public static boolean canDevide(int [] arr){
        
        if(arr==null || arr.length<2){ 
            return false;
        }
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        if(sum%2!=0){ 
            return false;
        }
        int target=sum/2;
        sum=0;
        for(int i:arr){
            sum+=i;
            if(sum==target)
                return true;
        }
        return false;
    }
    
    /*  Problem 4
        Write a method which given a string, returns a string with an asterisk inserted between every character in the original.  
        Use recursion in your solution. */
    public static String insertCharacter(String input){
        if(input.length()==1)
            return input;
        
        return new StringBuilder()
            .append(input.charAt(0))
            .append("*")
            .append(insertCharacter(input.substring(1))).toString();
    }
}
