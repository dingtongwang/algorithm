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

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight())) + 1;
  }

  /**
   * @description: 平衡树——左右子树高度差小于等于 1
   * @Param: [root]
   * @return: boolean
   * @author: tongwang.ding
   * @date: 2021-07-18
   */
  public static boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    boolean result = checkDepth(root);
    if (result) {
      return isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

    return false;
  }

  private static boolean checkDepth(TreeNode root) {
    int l = maxDepth(root.getLeft());
    int r = maxDepth(root.getRight());
    return Math.abs(l - r) <= 1;
  }

  public static TreeNode swapLeftAndRight(TreeNode root) {
    if (root != null) {
      TreeNode temp = root.getLeft();
      root.setLeft(root.getRight());
      root.setRight(temp);

      swapLeftAndRight(root.getLeft());
      swapLeftAndRight(root.getRight());
    }

    return root;
  }

  public static boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (root.getLeft() != null && root.getRight() == null) {
      return false;
    }

    if (root.getLeft() == null && root.getRight() != null) {
      return false;
    }

    if (root.getLeft().getValue() != root.getLeft().getValue()) {
      return false;
    }

    swapLeftAndRight(root.getRight());

    List<Integer> list1 = preOrderTraversal(root.getLeft());
    List<Integer> list2 = preOrderTraversal(root.getRight());

    List<Integer> list3 = inorderTraversal(root.getLeft());
    List<Integer> list4 = inorderTraversal(root.getRight());

    List<Integer> list5 = postOrderTraversal(root.getLeft());
    List<Integer> list6 = postOrderTraversal(root.getRight());

    return list1.equals(list2) && list3.equals(list4) && list5.equals(list6);
  }

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

  public static List<Integer> postOrderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList();
    postOrder(result, root);
    return result;
  }

  private static void postOrder(List<Integer> result, TreeNode node) {
    if (node != null) {
      postOrder(result, node.getLeft());
      postOrder(result, node.getRight());
      result.add(node.getValue());
    }
  }
}
