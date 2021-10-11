package com.prepared.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 美团面试题
 * 广度遍历的变种
 *
 */
public class MeiTuan {

    public static void main(String[] args) {
        Day40TreeSequenceTraversal102.TreeNode node1 = new Day40TreeSequenceTraversal102.TreeNode(15, null, null);
        Day40TreeSequenceTraversal102.TreeNode node2 = new Day40TreeSequenceTraversal102.TreeNode(7, null, null);
        Day40TreeSequenceTraversal102.TreeNode node3 = new Day40TreeSequenceTraversal102.TreeNode(20, node1, node2);
        Day40TreeSequenceTraversal102.TreeNode node4 = new Day40TreeSequenceTraversal102.TreeNode(9, null, null);
        Day40TreeSequenceTraversal102.TreeNode node5 = new Day40TreeSequenceTraversal102.TreeNode(3, node4, node3);
        MeiTuan meiTuan = new MeiTuan();
        List<List<Integer>> lists = meiTuan.levelOrder(node5);
        for(int i = 0; i < lists.size(); i++) {
            for(int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(Day40TreeSequenceTraversal102.TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<Day40TreeSequenceTraversal102.TreeNode> queue = new LinkedList<Day40TreeSequenceTraversal102.TreeNode>();
        queue.offer(root);
        // 从左到右
        boolean flag = false;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int currentLevelSize = queue.size();
            for(int i = 0; i < currentLevelSize; i++) {
                Day40TreeSequenceTraversal102.TreeNode node = queue.poll();
                list.add(node.val);
                // 从右到左
                if(flag) {
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }else {
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                }
            }
            flag = flag ? false : true;
            result.add(list);
        }
        return result;
    }

}
