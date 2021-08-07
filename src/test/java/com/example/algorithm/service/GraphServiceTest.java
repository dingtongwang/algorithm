package com.example.algorithm.service;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.algorithm.model.Graph;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * @description: reference：https://www.baeldung.com/java-graphs
 * @author: tongwang.ding
 * @date: 2021-07-20
 */
class GraphServiceTest {

  @Test
  void should_return_correct_graph() {
    // Given
    Graph graph = createGraph();

    // When
    // Then
    assertEquals(5, graph.getNumberOfVertex());
    assertEquals(2, graph.getNumberOfEdgeForVertex("A"));
    assertEquals(4, graph.getNumberOfEdgeForVertex("C"));
  }

  @Test
  void should_return_correct_list_when_call_depth_first_traversal() {
    // Given
    Graph graph = createGraph();

    // When
    Set<String> vertices = GraphService.depthFirstTraversal(graph, "A");
    List<String> vertexList = new ArrayList<>(vertices);

    // Then
    assertEquals(5, vertexList.size());
    assertEquals(newArrayList("A", "C", "E", "D", "B"), vertexList);
  }

  @Test
  void should_return_correct_list_when_call_breadth_first_traversal() {
    // Given
    Graph graph = createGraph();

    // When
    Set<String> vertices = GraphService.breadthFirstTraversal(graph, "A");
    List<String> vertexList = new ArrayList<>(vertices);

    // Then
    assertEquals(5, vertexList.size());
    assertEquals(newArrayList("A", "B", "C", "D", "E"), vertexList);
  }

  private Graph createGraph() {
    Graph graph = new Graph();
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addVertex("D");
    graph.addVertex("E");

    graph.addEdgeForUndirectedGraph("A", "B");
    graph.addEdgeForUndirectedGraph("A", "C");
    graph.addEdgeForUndirectedGraph("B", "C");
    graph.addEdgeForUndirectedGraph("C", "D");
    graph.addEdgeForUndirectedGraph("C", "E");
    graph.addEdgeForUndirectedGraph("D", "E");
    return graph;
  }
}