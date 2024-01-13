package medium.binaryTreeLevelOrderTraversal;


import utils.TreeNode.TreeNode;

import java.util.*;

public class Solution {

    private List<List<TreeNode>> orderedNodes = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        this.orderNodes(root);
        return this.mapToNodeValues();
    }

    private void orderNodes(TreeNode root) {
        if(root == null) return;
        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);
        orderedNodes.add(rootList);
        boolean hasAnyChildren = true;
        while (hasAnyChildren) hasAnyChildren = addChildNodes();
    }

    private boolean addChildNodes() {
        List<TreeNode> lastRow = orderedNodes.get(orderedNodes.size() - 1);
        List<TreeNode> children = new ArrayList<>();
        for(TreeNode node : lastRow){
            if(node.left != null) children.add(node.left);
            if(node.right != null) children.add(node.right);
        }

        if(children.isEmpty()) return false;
        orderedNodes.add(children);
        return true;
    }

    private List<List<Integer>> mapToNodeValues(){
        List<List<Integer>> nodeValues = new ArrayList<>();
        for(List<TreeNode> nodesList : orderedNodes){
            List<Integer> values = new ArrayList<>();
            for(TreeNode node : nodesList){
                values.add(node.val);
            }

            nodeValues.add(values);
        }

        return nodeValues;
    }

    public List<List<Integer>> levelOrderOptimal(TreeNode root) {
        List<List<Integer>> orderedValues = new ArrayList<>();
        Queue<TreeNode> nodesQueue = new LinkedList<>();

        if (root == null) return orderedValues;
        nodesQueue.add(root);

        while (!nodesQueue.isEmpty()) {
            int nodesCount = nodesQueue.size();
            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < nodesCount; i++) {
                TreeNode currentNode = nodesQueue.poll();
                values.add(currentNode.val);
                if (currentNode.left != null) nodesQueue.add(currentNode.left);
                if (currentNode.right != null) nodesQueue.add(currentNode.right);
            }

            orderedValues.add(values);
        }

        return orderedValues;
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                ));
        List<List<Integer>> orderedValues = new Solution().levelOrder(three);
        System.out.println(orderedValues);

        TreeNode one = new TreeNode(1);
        orderedValues = new Solution().levelOrder(one);
        System.out.println(orderedValues);

        orderedValues = new Solution().levelOrder(null);
        System.out.println(orderedValues);
    }
}
