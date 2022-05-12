package com.roc.leetcode.editor.cn.common;

/**
 * @Description TreeNode
 * @Author penn
 * @Date 2021/10/4 23:05
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

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
