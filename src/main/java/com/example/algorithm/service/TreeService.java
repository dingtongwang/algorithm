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
    preOrder(result, root);
    return result;
  }

  private static void preOrder(List<Integer> result, TreeNode node) {
    if (node != null) {
      result.add(node.getValue());
      preOrder(result, node.getLeft());
      preOrder(result, node.getRight());
    }
  }

  public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList();
    inorder(result, root);
    return result;
  }

  private static void inorder(List<Integer> result, TreeNode node) {
    if (node != null) {
      inorder(result, node.getLeft());
      result.add(node.getValue());
      inorder(result, node.getRight());
    }
  }
}
