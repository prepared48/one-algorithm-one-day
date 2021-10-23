package com.prepared.interview;

import com.prepared.baseutil.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树
 * [1, 2, 3, null, 2, 4, null, 5, 5]
 *
 *
 *
 */
public class Baidu4 {


    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, node5, null);
        TreeNode node3 = new TreeNode(3, node4, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node1 = new TreeNode(1, node2, node3);

        Baidu4 baidu4 = new Baidu4();
        List<Integer> integerList = baidu4.serial(node1, 4);
        PrintUtil.print(integerList);

    }


    public List<Integer> serial(TreeNode root, int depth) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            res.add(null);
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int k = 1;
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }else if(node.left == null && k < depth) {
                    queue.offer(new TreeNode(null, null, null));
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }else if(node.right == null && k < depth) {
                    queue.offer(new TreeNode(null, null, null));
                }
            }
            k++;
        }

        PrintUtil.print(res);
        // 压缩
        List<Integer> result = new ArrayList<>();
        int temp = 0;
        for(int i = 0; i < res.size(); i++) {
            if(res.get(i) != null) {
                result.add(res.get(i));
                continue;
            }
            while (i < res.size() && res.get(i) == null ) {
                temp++;
                i++;
            }
            i -= 1;
            result.add(null);
            result.add(temp);
            temp = 0;
        }
        return result;
    }





    static class TreeNode  {
        private Integer val;

        private TreeNode left;

        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(Integer val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
