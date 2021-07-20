package com.example.algorithm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: algorithm
 * @description:
 * @author: tongwang.ding
 * @date: 2021-07-19 22:43
 **/
public class Graph {
  private Map<Vertex, List<Vertex>> adjacencyList;

  public Graph() {
    adjacencyList = new HashMap<>();
  }

  public int getNumberOfVertex() {
    return adjacencyList.size();
  }

  public List<Vertex> getAdjVertex(String label) {
    return adjacencyList.get(new Vertex(label));
  }

  public int getNumberOfEdgeForVertex(String label) {
    return adjacencyList.get(new Vertex(label)).size();
  }

  public void addVertex(String label) {
    adjacencyList.putIfAbsent(new Vertex(label), new ArrayList<>());
  }

  public void removeVertex(String label) {
    Vertex v = new Vertex(label);
    adjacencyList.values().forEach(e -> e.remove(v));
    adjacencyList.remove(new Vertex(label));
  }

  /**
   * @description: 针对无向图
   * @Param: [label1, label2]
   * @return: void
   * @author: tongwang.ding
   * @date: 2021-07-20
   */
  public void addEdgeForUndirectedGraph(String label1, String label2) {
    Vertex v1 = new Vertex(label1);
    Vertex v2 = new Vertex(label2);
    adjacencyList.get(v1).add(v2);
    adjacencyList.get(v2).add(v1);
  }

  public void removeEdgeForUndirectedGraph(String label1, String label2) {
    Vertex v1 = new Vertex(label1);
    Vertex v2 = new Vertex(label2);

    List<Vertex> eV1 = adjacencyList.get(v1);
    List<Vertex> eV2 = adjacencyList.get(v2);

    if (eV1 != null) {
      eV1.remove(v2);
    }

    if (eV2 != null) {
      eV2.remove(v1);
    }
  }
}
