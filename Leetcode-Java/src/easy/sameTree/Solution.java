package easy.sameTree;

import utils.TreeNode.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        boolean areSame = isSameTree(p.left, q.left);
        if(!areSame) return false;
        areSame = isSameTree(p.right, q.right);
        return areSame;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSameTree(
                new TreeNode(1,
                        null,
                        new TreeNode(3)),
                new TreeNode(1,
                        null,
                        new TreeNode(3))
        ));

        System.out.println(new Solution().isSameTree(
                new TreeNode(1,
                        null,
                        new TreeNode(3)),
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3))
        ));

        System.out.println(new Solution().isSameTree(
                new TreeNode(1,
                        new TreeNode(22),
                        new TreeNode(3)),
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3))
        ));
    }
}
