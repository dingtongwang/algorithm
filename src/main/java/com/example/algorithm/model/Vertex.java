package com.example.algorithm.model;

import lombok.Data;

/**
 * @program: algorithm
 * @description:
 * @author: tongwang.ding
 * @date: 2021-07-19 22:41
 **/
@Data
public class Vertex {

  private String label;

  public Vertex(String label) {
    this.label = label;
  }
}
