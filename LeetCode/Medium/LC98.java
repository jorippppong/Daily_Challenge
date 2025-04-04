package leetcode.medium;

/*
1. 아이디어 : 
DFS
왼쪽 서브트리 검사 시: max를 현재 노드 값으로 업데이트하여 모든 값이 현재 노드보다 작아야 함을 보장
오른쪽 서브트리 검사 시: min을 현재 노드 값으로 업데이트하여 모든 값이 현재 노드보다 커야 함을 보장

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
DFS, 재귀
*/

public class LC98 {
    
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
    
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean dfs(TreeNode node, long min, long max) {
            if (node == null) return true;
            if(node.val <= min || node.val >= max) return false;

            return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
        }
    }

}
