package week03.g20200343040172;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 本周作业
 * LeetCode- 105 Construct binary tree from preorder and inorder traversal 从前序与中序遍历序列构造二叉树 二叉树的前序遍历
 */
public class LeetCode_105_0172 {
    /**
     * 使用递归的方式
     */
    class Solution {
        // start from first preorder element
        int pre_idx = 0;
        int[] preorder;
        int[] inorder;
        HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

        public TreeNode helper(int in_left, int in_right) {
            // if there is no elements to construct subtrees
            if (in_left == in_right) {
                return null;
            }

            // pick up pre_idx element as a root
            int root_val = preorder[pre_idx];
            TreeNode root = new TreeNode(root_val);

            // root splits inorder list
            // into left and right subtrees
            int index = idx_map.get(root_val);

            // recursion
            pre_idx++;
            // build left subtree
            root.left = helper(in_left, index);
            // build right subtree
            root.right = helper(index + 1, in_right);
            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;

            // build a hashmap value -> its index
            int idx = 0;
            for (Integer val : inorder){
                idx_map.put(val, idx++);
            }
            return helper(0, inorder.length);
        }
    }
}
