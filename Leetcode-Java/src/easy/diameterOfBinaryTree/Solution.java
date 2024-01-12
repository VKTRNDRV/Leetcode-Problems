package easy.diameterOfBinaryTree;

import utils.TreeNode.TreeNode;

public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int maxDistance = 0;
        TreeNode pointer = root;
        while (true){
            int depthLeft = getMaxDepth(pointer.left);
            int depthRight = getMaxDepth(pointer.right);
            int currentDistance = depthLeft + depthRight;
            if(currentDistance == 0){
                break;
            }else if(currentDistance > maxDistance){
                maxDistance = currentDistance;
            }

            if(depthLeft > depthRight){
                pointer = pointer.left;
            }else{
                pointer = pointer.right;
            }
        }

        return maxDistance;
    }

    private int getMaxDepth(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().diameterOfBinaryTree(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3)
        )));
        System.out.println(new Solution().diameterOfBinaryTree(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                null),
                        null)
        ));
    }
}
