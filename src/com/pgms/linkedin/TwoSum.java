package com.pgms.linkedin;

import java.util.HashSet;
import java.util.Set;

public interface TwoSum {
    /**
     * Stores @param input in an internal data structure.
     */
    void store(int input);

    /**
     * Returns true if there is any pair of numbers in the internal data structure which
     * have sum @param val, and false otherwise.
     * For example, if the numbers 1, -2, 3, and 6 had been stored,
     * the method should return true for 4, -1, and 9, but false for 10, 5, and 0
     */
    boolean test(int val);
}


 class TwoSumImpl implements TwoSum{

    Set<Integer> inputs=new HashSet<Integer>();


    public void store(int input){
        inputs.add(input);

    }


    public boolean test(int val){
        for(Integer num: inputs){
            if(inputs.contains(val-num)){
                return true;
            }
        }
        return false;
    }

}