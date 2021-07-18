package com.example.algorithm.model;

import lombok.Data;

/**
 * @program: algorithm
 * @description: Tree Node
 * @author: tongwang.ding
 * @date: 2021-07-18 14:01
 **/
@Data
public class TreeNode {

  private int value;

  private TreeNode left;
  private TreeNode right;

  private TreeNode() {
  }

  public TreeNode(int value) {
    this.value = value;
  }

  public TreeNode(int value, TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}
