class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    // Helper function to recursively calculate the sum
    private int helper(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }

        // Update the current sum by shifting digits and adding the current node's value
        currentSum = currentSum * 10 + root.val;
        
        // If it's a leaf node, return the current sum
        if (root.left == null && root.right == null) {
            return currentSum;
        }
        
        // Recursively calculate the sum for left and right subtrees
        return helper(root.left, currentSum) + helper(root.right, currentSum);
    }
}