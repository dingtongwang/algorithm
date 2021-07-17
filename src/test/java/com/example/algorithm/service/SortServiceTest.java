package com.example.algorithm.service;

import org.junit.jupiter.api.Test;

class SortServiceTest {

  @Test
  void should_return_correct_data_list_when_call_insertion_sort() {
    Integer[] data = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
    SortService.insertionSort(data);

    for (int num : data) {
      System.out.println(num);
    }
  }

  @Test
  void should_return_correct_data_list_when_call_selection_sort() {
    Integer[] data = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
    SortService.selectionSort(data);

    for (int num : data) {
      System.out.println(num);
    }
  }


  @Test
  void should_return_correct_data_list_when_call_merge_sort() {
    int[] data = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
    SortService.mergeSort(data);

    for (int num : data) {
      System.out.println(num);
    }
  }

  @Test
  void should_return_correct_data_list_when_call_quick_sort() {
    int[] data = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
    SortService.quickSort(data);

    for (int num : data) {
      System.out.println(num);
    }
  }
}