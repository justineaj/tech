package com.pgms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeHirarchy {

    public static String [][] input={
            {"John","Mary"},//John reports to Mary
            {"Ram","Mary"},
            {"Mary",null},
            {"Jack","Ram"},
            {"Phil","Jack1"}
    };
    public static Map<String,Emp> empMap=new HashMap<String,Emp>();
    public static Emp root=null;
    
    public static void main(String args[]){
        build();
       printSubordinate(empMap.get("Jack1")); 
    }
    
    public static void printSubordinate(Emp e){
        if(e!=null){
            System.out.println(e.name);
            for(Emp emp:e.reporties){
                printSubordinate(emp);
            }
        }
        
    }
    
    
    public static void build(){
        for(int i=0;i<input.length;i++){
            Emp  reportie=addToMap(input[i][0]);
            if(input[i][1]==null){
               root=reportie; 
            }
            else{
                Emp  manageEmp=addToMap(input[i][1]);
                manageEmp.addreportie(reportie);    
            }
            
        }
    }
    
    public static Emp addToMap(String empStr){
        Emp e=null;
        if(empMap.get(empStr)!=null){
            e=empMap.get(empStr);
        }
        else{
            e=new Emp(empStr);
            empMap.put(empStr, e);
        }
        return e;
    }
    
}

  class Emp{
    public Emp(String name){
        this.name=name;
    }
    public String name;
    List<Emp> reporties=new ArrayList<Emp>();
    public void addreportie(Emp e){
        reporties.add(e);
    }
}
