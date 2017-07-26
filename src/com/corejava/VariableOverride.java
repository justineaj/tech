package com.corejava;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/23/16
 * Time: 8:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class VariableOverride {

    public static void main(String args[]){
       System.out.println(new Base().myMeThod());
        System.out.println(new SubClass().myMeThod());


    }

}



class Base{
    String baseVariable="BaseClass";

    public String  myMeThod(){
        return baseVariable;
    }
}

class SubClass extends Base{
    String baseVariable="SubClass";

    public String  myMeThod(){
        return baseVariable;
//        return super.baseVariable;
    }
}