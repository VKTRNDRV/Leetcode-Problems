package easy.invertBinaryTree;

import utils.TreeNode.TreeNode;

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode two = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));

        two = new Solution().invertTree(two);
        System.out.println(two);

        TreeNode four = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)));

        four = new Solution().invertTree(four);
        System.out.println(four);
    }
}
