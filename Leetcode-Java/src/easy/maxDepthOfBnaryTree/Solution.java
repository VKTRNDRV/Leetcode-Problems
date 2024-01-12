package easy.maxDepthOfBnaryTree;

import utils.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> nodes = new ArrayList<>();
        List<TreeNode> childNodes = new ArrayList<>();
        nodes.add(root);
        int depth = 1;
        while (true){
            for(TreeNode node : nodes){
                if(node.left != null){
                    childNodes.add(node.left);
                }

                if(node.right != null){
                    childNodes.add(node.right);
                }
            }

            if(childNodes.isEmpty()) break;
            nodes = childNodes;
            childNodes = new ArrayList<>();
            depth++;
        }

        return depth;
    }

    public int maxDepthOptimal(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(maxDepthOptimal(root.left), maxDepthOptimal(root.right));
    }

    public static void main(String[] args) {
        TreeNode four = new TreeNode(4,
                new TreeNode(2,
                        null,
                        new TreeNode(3)),
                new TreeNode(7,
                        null,
                        null));

        System.out.println(new Solution().maxDepth(four));
    }
}
