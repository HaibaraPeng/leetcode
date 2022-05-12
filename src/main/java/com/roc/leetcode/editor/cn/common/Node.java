package com.roc.leetcode.editor.cn.common;

/**
 * @Description Node
 * @Author penn
 * @Date 2021/10/4 23:08
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
