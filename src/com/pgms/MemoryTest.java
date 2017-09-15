package com.pgms;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 11/24/14
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class MemoryTest {

//    -XX:+PrintGC
    public static void main(String args[]){

        Map<Object,Object> mp=new HashMap<Object,Object>();

        int i=0;
        int csec=0;
        while(true){

            mp.put(new Object(),new int[10000]);
            csec=new Date().getSeconds();
            if(i!=csec){
            System.out.print(".");
                i=0;
                i=new Date().getSeconds();
            }
        }


    }
}
