package easy.subtreeOfAnotherTree;

import utils.TreeNode.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        boolean areSame = isSameTree(p.left, q.left);
        if(!areSame) return false;
        areSame = isSameTree(p.right, q.right);
        return areSame;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubtree(
                new TreeNode(3,
                        new TreeNode(4,
                                new TreeNode(1),
                                new TreeNode(2)),
                        new TreeNode(5)),
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2,
                                new TreeNode(0),
                                null))
        ));

        System.out.println(new Solution().isSubtree(
                new TreeNode(3,
                        new TreeNode(4,
                                new TreeNode(1),
                                new TreeNode(2)),
                        new TreeNode(5)),
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2))
        ));
    }
}
