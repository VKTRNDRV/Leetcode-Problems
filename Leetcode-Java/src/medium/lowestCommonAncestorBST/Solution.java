package medium.lowestCommonAncestorBST;

import utils.TreeNode.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean areBothLeft = isSameOrChild(root.left, p) && isSameOrChild(root.left, q);
        boolean areBothRight = isSameOrChild(root.right, p) && isSameOrChild(root.right, q);

        if(areBothLeft) return lowestCommonAncestor(root.left, p, q);
        else if(areBothRight) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }

    private boolean isSameOrChild(TreeNode root, TreeNode target){
        if(root == null || target == null) return false;
        if(root == target) return true;
        boolean isFound = false;
        if(root.left != null){
            isFound = isSameOrChild(root.left, target);
        }

        if(isFound) return true;

        if(root.right != null){
            isFound = isSameOrChild(root.right, target);
        }
        return isFound;
    }
}
