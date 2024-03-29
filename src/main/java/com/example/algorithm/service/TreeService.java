package com.example.algorithm.service;

import com.example.algorithm.model.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
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

  public static boolean isEqual(TreeNode treeA, TreeNode treeB) {
    if ((treeA == null)) {
      return treeB == null;
    }

    if (treeB == null) {
      return false;
    }

    if (treeA.getValue() == treeB.getValue()) {
      return isEqual(treeA.getLeft(), treeB.getLeft()) && isEqual(treeA.getRight(), treeB.getRight());
    }

    return false;
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

  /**
   * @description: 判读树是否是对称树
   * @Param: [root]
   * @return: boolean
   * @author: tongwang.ding
   * @date: 2021-07-31
   */
  public static boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    return isSymmetric(root.getLeft(), root.getRight());
  }

  private static boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }

    if (left == null || right == null || left.getValue() != right.getValue()) {
      return false;
    }

    return isSymmetric(left.getLeft(), right.getRight()) && isSymmetric(left.getRight(), right.getLeft());
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

  /**
   * @description: 水平遍历
   * @Param: [root]
   * @return: java.util.ArrayList<java.util.ArrayList<java.lang.Integer>>
   * @author: tongwang.ding
   * @date: 2021-08-27
   */
  public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    // write code here
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      ArrayList<Integer> levelNodes = new ArrayList<>();
      int size = queue.size();
      for (int i = 1; i <= size; i++) {
        traversal(levelNodes, queue);
      }
      list.add(levelNodes);
    }

    return list;
  }

  private static void traversal(ArrayList<Integer> levelValues, LinkedList<TreeNode> queue) {
    TreeNode node = queue.pop();
    if (node != null) {
      levelValues.add(node.getValue());

      if (node.getLeft() != null) {
        queue.add(node.getLeft());
      }

      if (node.getRight() != null) {
        queue.add(node.getRight());
      }
    }
  }
}
