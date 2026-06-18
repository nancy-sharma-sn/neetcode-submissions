/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
        List<Integer> res = new ArrayList<>();

public List<Integer> rightSideView(TreeNode root) {
    dfs(root, 0);
    return res;
}

private void dfs(TreeNode node, int depth) {
    if (node == null) return;

    if (res.size() == depth) {
        res.add(node.val);        // first node at this depth = rightmost
    }

    dfs(node.right, depth + 1);   // go right FIRST
    dfs(node.left, depth + 1);    // then left
}
        
    }
