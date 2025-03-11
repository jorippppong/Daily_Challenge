package LeetCode.Hard;

import java.util.LinkedList;
import java.util.Queue;

/*
1. 아이디어 : 
BFS

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
BFS, Queue
*/

public class LC_112 {
    
    //Definition for a binary tree node.
    class TreeNode {
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

    class Node{
        TreeNode treeNode;
        int sum;

        Node(TreeNode treeNode, int sum){
            this.treeNode = treeNode;
            this.sum = sum;
        }
    }
    
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            // BFS
            Queue<Node> q = new LinkedList<>();
            if(root == null) return false;
            q.add(new Node(root, root.val));
            while(!q.isEmpty()){
                Node curr = q.poll();
                if(curr.sum == targetSum && curr.treeNode.left == null && curr.treeNode.right == null) return true;
                if(curr.treeNode.left != null) q.add(new Node(curr.treeNode.left, curr.sum + curr.treeNode.left.val));
                if(curr.treeNode.right != null) q.add(new Node(curr.treeNode.right, curr.sum + curr.treeNode.right.val));
            }
            return false;
        }
    }
}
