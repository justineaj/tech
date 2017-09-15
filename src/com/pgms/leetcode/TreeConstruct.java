package com.pgms.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 1/27/15
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class TreeConstruct {

    public static void main(String args[]){

        Map<Object,Object> m=new HashMap<Object,Object>();
        boolean b=true;
        long k=0;
//        while(b){
//            String p=k+++"PasswordPasswordPasswordPasswordPasswordPasswordPasswordPasswordPasswordPasswordPasswordPasswordPasswordPasswordPasswordPasswordPasswordPasswordPasswordPasswordPassword";
//            Map mp=new HashMap();
//            mp.put(new int[100000],new HashMap());
//            m.put(p,mp);
//            if(k%100000==0){
//                System.out.println(k);
//            }
//        }


        new TreeConstruct().buildTree(new int[]{1,2},new int[]{1,2});
    }



    Map<Integer,Integer> inorder_Map=new HashMap<Integer,Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0 ){
            return null;
        }

        for(int i=0;i<inorder.length;i++){
            inorder_Map.put(inorder[i],i);
        }
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }

    public TreeNode buildTree(int[] preorder,int preeLeft,int preeRight, int[] inorder,int inLeft,int inRight) {
        if(preeRight<preeLeft || inRight<inLeft||  preeRight>preorder.length-1 || inRight>inorder.length-1){
            return null;
        }
        TreeNode node=new TreeNode(preorder[preeLeft]);
        int indexMp=inLeft;
        if(inorder_Map.get(preorder[preeLeft])!=null){
            indexMp=inorder_Map.get(preorder[preeLeft]);
        }
        int length=indexMp-inLeft;

        node.left=buildTree(preorder,preeLeft+1,preeLeft+length,inorder,inLeft,indexMp-1);
        node.right=buildTree(preorder,preeLeft+length+1,preeRight,inorder,indexMp+1,inRight);
        return node;


    }

}