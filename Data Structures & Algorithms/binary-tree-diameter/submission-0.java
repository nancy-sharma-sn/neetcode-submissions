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
    static class TreeInfo{
        int diam;
        int height;
        TreeInfo(int diam,int height){
            this.diam = diam;
            this. height = height;
        }
    }
    public static TreeInfo diam (TreeNode root){
        if(root==null){
            return new TreeInfo(0,0);
        }

        TreeInfo left = diam(root.left);
        TreeInfo right = diam(root.right);

        int myHeight = Math.max(left.height,right.height)+1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.height + right.height ;

        int myDiam = Math.max(Math.max(diam1,diam2),diam3);

        TreeInfo myInfo = new TreeInfo(myDiam, myHeight);

        return myInfo;
    }
    
    public static int diameterOfBinaryTree(TreeNode root) {
        int diameter = diam(root).diam;
        return diameter;               
        
    }
}
