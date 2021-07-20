package com.example.algorithm.service;

import com.example.algorithm.model.Graph;
import com.example.algorithm.model.Vertex;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @program: algorithm
 * @description:
 * @author: tongwang.ding
 * @date: 2021-07-20 09:20
 **/
public class GraphService {

  /**
   * @description: 深度优先遍历，Note：深度优先遍历的结果不唯一（即使从同一个结点出发）
   * @Param: [graph, root]
   * @return: java.util.Set<java.lang.String>
   * @author: tongwang.ding
   * @date: 2021-07-20
   */
  public static Set<String> depthFirstTraversal(Graph graph, String root) {
    Set<String> visited = new LinkedHashSet<>();

    Stack<String> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      String vertex = stack.pop();
      if (!visited.contains(vertex)) {
        visited.add(vertex);
        for (Vertex v : graph.getAdjVertex(vertex)) {
          stack.push(v.getLabel());
        }
      }
    }

    return visited;
  }

  public static Set<String> breadthFirstTraversal(Graph graph, String root) {
    Set<String> visited = new LinkedHashSet<String>();
    Queue<String> queue = new LinkedList<String>();
    queue.add(root);
    visited.add(root);

    while (!queue.isEmpty()) {
      String vertex = queue.poll();
      for (Vertex v : graph.getAdjVertex(vertex)) {
        if (!visited.contains(v.getLabel())) {
          visited.add(v.getLabel());
          queue.add(v.getLabel());
        }
      }
    }
    return visited;
  }
}
