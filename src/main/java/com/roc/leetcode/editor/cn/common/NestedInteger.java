package com.roc.leetcode.editor.cn.common;

import java.util.List;

/**
 * @Description NestedInteger
 * @Author dongp
 * @Date 2022/5/12 0012 10:34
 */
public interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}
