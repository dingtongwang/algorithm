package com.example.algorithm.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SortServiceTest {

  private static int[] nums;

  @BeforeAll
  private static void initData() {
    nums = new int[]{10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
  }

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
    SortService.mergeSort(nums);

    for (int num : nums) {
      System.out.println(num);
    }
  }

  @Test
  void should_return_correct_data_list_when_call_quick_sort() {
    SortService.quickSort(nums);

    for (int num : nums) {
      System.out.println(num);
    }
  }

  @Test
  void should_return_correct_data_list_when_call_shell_sort() {
    SortService.shellSort(nums);

    for (int num : nums) {
      System.out.println(num);
    }
  }
}