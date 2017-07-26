package com.test;

import java.util.HashMap;
import java.util.Map;

public class ChangeHashCodeTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Map<Emp,String> mp=new HashMap<Emp,String>();
        Emp emp=new Emp();
        mp.put(emp, "");
        
        System.out.println(mp.containsKey(new Emp()));
        emp.hash=300;
        System.out.println(mp.containsKey(new Emp()));

    }

   static class Emp{
        public int hash=123;
        
        
        @Override
        public int hashCode(){
            return hash;
        }
        
        @Override
        public boolean equals(Object e){
            return true;
        }
    }
    
    
}
