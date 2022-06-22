package cn.young.leetcode_20220622;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    int currHeight = 0;
    int result = 0;

    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        val(root, 0);
        return result;
    }

    void val(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        height++;
        val(root.left, height);
        val(root.right, height);
        if (height > currHeight) {
            currHeight = height;
            result = root.val;
        }
    }
}