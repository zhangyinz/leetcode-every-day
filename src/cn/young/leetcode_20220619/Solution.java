package cn.young.leetcode_20220619;

import java.util.*;

/**
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * <p>
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/most-frequent-subtree-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    Map<Integer, Integer> numSumMap = new HashMap<>();
    int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        count(root);
        Iterator<Map.Entry<Integer, Integer>> iterator = numSumMap.entrySet().iterator();
        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> map = iterator.next();
            if (maxCount == map.getValue()) {
                result.add(map.getKey());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5, new TreeNode(2), new TreeNode(-3));
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findFrequentTreeSum(node)));
    }

    public int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //深搜
        int sum = node.val + count(node.left) + count(node.right);
        numSumMap.put(sum, numSumMap.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, numSumMap.get(sum));
        return sum;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
