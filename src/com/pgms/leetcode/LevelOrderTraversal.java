package com.pgms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 1/6/15
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return null;
        }

        List<List<TreeNode>>  parentList=new ArrayList<List<TreeNode>>();
        List<TreeNode> list=new ArrayList<TreeNode>();
        list.add(root);
        parentList.add(list);

        while(list.size()>0){
            List<TreeNode>  nextList=new ArrayList<TreeNode>();
            for(TreeNode n:list){
                if(n.left!=null){
                    nextList.add(n.left) ;
                }
                if(n.right!=null){
                    nextList.add(n.right) ;
                }
            }
            parentList.add(nextList);
            list=nextList;
        }


        List<List<Integer>>  retParentList=null;
        if(parentList.size()>0){
             retParentList=new ArrayList<List<Integer>>();
            for(List<TreeNode> lst :parentList){
                List<Integer> il=new ArrayList<Integer>();
                    for(TreeNode n:lst){
                        il.add(n.val);
                    }
                retParentList.add(il);
            }

        }
         return retParentList;
    }
}
