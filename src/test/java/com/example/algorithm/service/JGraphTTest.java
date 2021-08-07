package com.example.algorithm.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description:
 * @author: tongwang.ding
 * @date: 2021-07-20 16:25
 **/
class JGraphTTest {

  private static DefaultDirectedGraph<String, DefaultEdge> g;

  @BeforeAll
  public static void createGraph() {
    File imgFile = new File("src/test/resources/graph.png");
    try {
      imgFile.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

    g = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);

    String x1 = "x1";
    String x2 = "x2";
    String x3 = "x3";

    g.addVertex(x1);
    g.addVertex(x2);
    g.addVertex(x3);

    g.addEdge(x1, x2);
    g.addEdge(x2, x3);
    g.addEdge(x3, x1);
  }

  @Test
  private void should_create_image_when_call_create_buffered_image_given_graph_adapter() throws IOException {

    JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<String, DefaultEdge>(g);
    mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
    layout.execute(graphAdapter.getDefaultParent());

    BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);

    File imgFile = new File("src/test/resources/graph.png");
    ImageIO.write(image, "PNG", imgFile);

    assertTrue(imgFile.exists());
  }
}
