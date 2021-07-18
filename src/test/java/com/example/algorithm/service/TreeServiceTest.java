package com.example.algorithm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.algorithm.model.TreeNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TreeServiceTest {

  private static TreeNode root;

  @BeforeAll
  static void initTree() {
    TreeNode node8 = new TreeNode(8);
    TreeNode node9 = new TreeNode(9);
    TreeNode node10 = new TreeNode(10);
    TreeNode node11 = new TreeNode(11);
    TreeNode node12 = new TreeNode(12);
    TreeNode node13 = new TreeNode(13);
    TreeNode node14 = new TreeNode(14);
    TreeNode node15 = new TreeNode(15);

    TreeNode node4 = new TreeNode(4, node8, node9);
    TreeNode node5 = new TreeNode(5, node10, node11);
    TreeNode node6 = new TreeNode(6, node12, node13);
    TreeNode node7 = new TreeNode(7, node14, node15);

    TreeNode node2 = new TreeNode(2, node4, node5);
    TreeNode node3 = new TreeNode(3, node6, node7);

    root = new TreeNode(1, node2, node3);
  }

  @Test
  void should_return_correct_result_when_call_pre_order_Traversal() {
    List<Integer> result = TreeService.preOrderTraversal(root);

    assertEquals(Arrays.asList(1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 13, 7, 14, 15), result);
  }

  @Test
  void should_return_correct_result_when_call_inorder_Traversal() {
    List<Integer> result = TreeService.inorderTraversal(root);

    assertEquals(Arrays.asList(8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15), result);
  }
}