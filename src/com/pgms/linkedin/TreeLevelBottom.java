package com.pgms.linkedin;

/**
 * Created by root on 6/23/17.
 */

import com.pgms.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 *
 *       3
        / \
       9  20
         /  \
        15   7
 *
 *
 */

public class TreeLevelBottom {


    public static void main(String args[]){
        TreeNode r=new TreeNode(3);
        r.left=new TreeNode(9);
        r.right=new TreeNode(20);
        r.right.left=new TreeNode(15);
        r.right.right=new TreeNode(7);
        new TreeLevelBottom().levelOrderBottom(r);
    }



    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        List<TreeNode> lv=new ArrayList<TreeNode>();
        lv.add(root);
        levelOrderBottom(lv,ret);
        return ret;
    }


    private void levelOrderBottom(List<TreeNode> lv,List<List<Integer>> ret){
        List<Integer> lst=null;

        while(lv.size()>0){
            lst=new ArrayList<Integer>();
            List<TreeNode> lvn=new ArrayList<TreeNode>();
            for(int i=0;i<lv.size();i++){
                TreeNode n=lv.get(i);
                lst.add(n.val);
                if(n.left!=null){
                    lvn.add(n.left);
                }
                if(n.right!=null){
                    lvn.add(n.right);
                }
            }
            lv=lvn;
            ret.add(0,lst);
        }
    }
}
