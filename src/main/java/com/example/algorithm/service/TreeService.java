package com.example.algorithm.service;

import com.example.algorithm.model.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description: Provides algorithms which operate tree structure
 * @author: tongwang.ding
 * @date: 2021-07-18 13:54
 **/
public class TreeService {

  public static List<Integer> preOrderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList();
    preorder(result, root);
    return result;
  }

  private static void preorder(List<Integer> result, TreeNode node) {
    if (node != null) {
      result.add(node.getValue());
      preorder(result, node.getLeft());
      preorder(result, node.getRight());
    }
  }
}
