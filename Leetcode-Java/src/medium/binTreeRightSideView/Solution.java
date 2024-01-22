package medium.binTreeRightSideView;

import utils.TreeNode.TreeNode;

import java.util.*;

class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> values = new ArrayList<Integer>();
        if (root == null) return values;
        addRightMostNodesValue(values, root);
        return values;
    }

    public void addRightMostNodesValue(List<Integer> values, TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int nodesInRowCount = nodes.size();
            for (int i = 0; i < nodesInRowCount; i++) {
                TreeNode cur = nodes.poll();
                if (i == 0) values.add(cur.val);
                if (cur.right != null) nodes.offer(cur.right);
                if (cur.left != null) nodes.offer(cur.left);
            }
        }
    }
}
