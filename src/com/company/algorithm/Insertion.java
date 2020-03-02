package com.company.algorithm;

/**
 * 插入排序
 * 1 将数组序列分为 排序区间和未排序区间
 * 2 从未排序区间筛选一个数据插入到已经排序好的区间扩大排序区间知道
 * <p>
 * 原地排序算法： 空间复杂度为O(1)
 * 稳定的排序算法： 当后来的元素比较相等的时候不进行交换
 * 时间复杂度：(只有在对排序算法进行优化的时候才存在最好和最坏情况 ，在未进行优化的时候即为最坏的时间复杂度)
 * 最好的情况：O(n) (当满有序度的时候只需要每轮比较只需比较一次即可 总共需要比较  n-1次)
 * 最坏的情况：O(n^2) (当满逆序度的时候每轮需要比较最多次数   总共需要比较   n*(n-1)/2    1 + 2 + 3 + .... + (n-1))
 */
public class Insertion {
    public static int[] insertSort(int[] data) {
        long startTime = System.currentTimeMillis();
        int n = data.length;
        if (n <= 1) return data;
        //  从为排序区间进行循环
        for (int i = 1; i < n; i++) {
            // 已经排序区间首次有一个愿随
            int j = i - 1;
            int value = data[i];
            for (; j >= 0; j--) {
                if (data[j] > value) {
                    // 移动数据
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序的耗时 time = " + (endTime - startTime));
        return data;
    }

    public static void main(String[] args) {
        System.out.println("插入排序");
        int[] testData = {3, 25, 3, 1, 2, 4, 9, 7};
        int[] insertSortData = insertSort(testData);
        for (int i : insertSortData) {
            System.out.println(i);
        }

    }
}
