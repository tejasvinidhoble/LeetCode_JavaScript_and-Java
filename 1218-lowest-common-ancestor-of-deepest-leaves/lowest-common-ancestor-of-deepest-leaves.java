public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root).lca;
    }

    private Result helper(TreeNode node) {
        if (node == null) {
            return new Result(null, 0);
        }
        
        Result left = helper(node.left);
        Result right = helper(node.right);

        if (left.depth > right.depth) {
            return new Result(left.lca, left.depth + 1);
        } else if (right.depth > left.depth) {
            return new Result(right.lca, right.depth + 1);
        } else { // If both sides have the same depth, current node is the LCA
            return new Result(node, left.depth + 1);
        }
    }

    private static class Result {
        TreeNode lca;
        int depth;
        Result(TreeNode lca, int depth) {
            this.lca = lca;
            this.depth = depth;
        }
    }
}
