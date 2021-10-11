package com.prepared.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 */
public class Day40TreeSequenceTraversal102 {

    public static void main(String[] args) {
        Day40TreeSequenceTraversal102 treeSequenceTraversal102 = new Day40TreeSequenceTraversal102();
        TreeNode node1 = new TreeNode(15, null, null);
        TreeNode node2 = new TreeNode(7, null, null);
        TreeNode node3 = new TreeNode(20, node1, node2);
        TreeNode node4 = new TreeNode(9, null, null);
        TreeNode node5 = new TreeNode(3, node4, node3);
//        TreeNode node1 = new TreeNode(2, null, null);
//        TreeNode node2 = new TreeNode(1, node1, null);
        List<List<Integer>> lists = treeSequenceTraversal102.levelOrder2(node5);
        for(int i = 0; i < lists.size(); i++) {
            for(int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    private List<Integer> getChild(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root.left != null) {
            list.add(root.left.val);
        }
        if(root.right != null) {
            list.add(root.right.val);
        }
        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        result.add(list);
        while (root != null && (root.left != null || root.right != null) ) {
            list = new ArrayList<>();
            if(root.left != null) {
                list.add(root.left.val);
            }
            if(root.right != null) {
                list.add(root.right.val);
                if(root.left == null) {
                    root = root.right;
                }
            }
            if(root.left != null && (root.left.left != null || root.left.right != null)) {
                root = root.left;
            }else {
                root = root.right;
            }
            result.add(list);
        }
        return result;
    }



//    Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
