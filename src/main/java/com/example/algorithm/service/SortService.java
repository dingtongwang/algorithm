package com.example.algorithm.service;

import org.springframework.stereotype.Service;

@Service
public class SortService {

  public static void insertionSort(Comparable[] data) {
    // 将data[]按升序排列
    int N = data.length;
    for (int i = 1; i < N; i++) {
      // 将data[i]插入到a[i-1]，data[i-2]，data[i-3]……之中
      for (int j = i; j > 0 && (data[j].compareTo(data[j - 1]) < 0); j--) {
        Comparable temp = data[j];
        data[j] = data[j - 1];
        data[j - 1] = temp;
      }
    }
  }

  public static void selectionSort(Comparable[] data) {
    int N = data.length;
    for (int i = 0; i < N - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < N; ++j) {
        if (data[j].compareTo(data[minIndex]) < 0) {
          minIndex = j;
        }
      }

      // 将最小值放到i的位置
      if (minIndex != i) {
        Comparable temp = data[i];
        data[i] = data[minIndex];
        data[minIndex] = temp;
      }
    }
  }

  // https://www.cnblogs.com/chengxiao/p/6194356.html
  public static void mergeSort(int[] nums) {
    int length = nums.length;
    int[] temp = new int[length];
    mergeSort(temp, nums, 0, length - 1);
  }

  private static void mergeSort(int[] temp, int[] nums, int left, int right) {
    if (left >= right) {
      return;
    }

    int mid = (left + right) >>> 1;

    mergeSort(temp, nums, left, mid);
    mergeSort(temp, nums, mid + 1, right);

    // 将两个有序数组合并
    merge(temp, nums, left, right, mid);
  }

  private static void merge(int[] temp, int[] nums, int left, int right, int mid) {
    int i = left; // 左序列指针
    int j = mid + 1; // 右序列指针
    int k = 0; // 临时数组指针

    // 比较nums[i]、nums[j]，将较小者填充到temp中，并移动i或者j
    while (i <= mid && j <= right) {
      if (nums[i] <= nums[j]) {
        temp[k++] = nums[i++];
      } else {
        temp[k++] = nums[j++];
      }
    }

    // 将左边剩余元素填充进temp中
    while (i <= mid) {
      temp[k++] = nums[i++];
    }

    // 将右序列剩余元素填充进temp中
    while (j <= right) {
      temp[k++] = nums[j++];
    }

    // 将temp中的元素全部拷贝到原数组中
    int m = 0;
    while (left <= right) {
      nums[left++] = temp[m++];
    }
  }

  public static void quickSort(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }

  private static void quickSort(int[] nums, int left, int right) {
    if (left >= right) {
      return;
    }

    int p = compareAndSwap(nums, left, right);

    quickSort(nums, left, p);
    quickSort(nums, p + 1, right);
  }

  private static int compareAndSwap(int[] nums, int left, int right) {
    int base = nums[left];

    int i = left;
    int j = right;

    while (i < j) {
      // 从右往左找一个小于基准位的数
      while ((i < j) && (nums[j] > base)) {
        j--;
      }

      // 从左往右找一个大于基准位的数
      while ((i < j) && (nums[i] < base)) {
        i++;
      }

      if (i < j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        j--;
      }
    }

    return j;
  }
}
