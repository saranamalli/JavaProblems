package learn.leetcode.trees;

public class MaxProductBySplittingBinTreeLC1339 {
    int totalSum, maxSum = Integer.MIN_VALUE;

    public int maxProduct(TreeNode root) {
        this.totalSum = calculateSum(root);
        // System.out.println("Sum: "+sum);
        calculateAnsSum(root);
        return this.maxSum;
    }

    public int calculateSum(TreeNode root) {
        if (root == null)
            return 0;
        return calculateSum(root.left) + calculateSum(root.right) + root.val;
    }

    public int calculateAnsSum(TreeNode root) {
        if (root == null)
            return 0;
        int sum = calculateAnsSum(root.left) + calculateAnsSum(root.right) + root.val;
        int product = sum*(this.totalSum - sum);
        this.maxSum = Math.max(this.maxSum, product);
        return sum;
    }

    public static void main(String[] args) {
        MaxProductBySplittingBinTreeLC1339 implement = new MaxProductBySplittingBinTreeLC1339();
        TreeNode root = implement.new TreeNode(1, implement.new TreeNode(2, implement.new TreeNode(4), implement.new TreeNode(5)), implement.new TreeNode(3, implement.new TreeNode(6), null));
        System.out.println(implement.maxProduct(root));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
