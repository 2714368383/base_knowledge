package com.company.algorithm;

import java.util.Random;

/**
 * 归并排序
 * 1 分治的方法的一个应用
 */
public class Merge {


    public static void sort(int[] a) {
        int s = 0;
        int e = a.length - 1;
        int m = (s + e) / 2;

        sortMerge(a, s, e, m);


    }

    /**
     * 分治递归排序
     *
     * @param a
     * @param s
     * @param e
     * @param m
     */
    private static void sortMerge(int[] a, int s, int e, int m) {

        // 终止条件
        if (e <= s) return;

        sortMerge(a, s, m, (s + m) / 2);
        sortMerge(a, m + 1, e, (m + 1 + e) / 2);
        merge(a, s, e, m);

    }


    /**
     * 合并有序数组
     *
     * @param a
     * @param s
     * @param e
     * @param m
     */
    public static void merge(int[] a, int s, int e, int m) {
        int l = s;
        int r = m + 1;
        int k = 0;
        //初始化临时数组
        int[] tempArray = new int[e - s + 1];

        // 都 有数组的时候
        while (l <= m && r <= e) {
            if (a[r] < a[l]) {
                tempArray[k++] = a[r++];
            } else {
                tempArray[k++] = a[l++];
            }
        }
        // 剩余右侧数组
        while (r <= e) {
            tempArray[k++] = a[r++];
        }
        // 剩余左侧数组
        while (l <= m) {
            tempArray[k++] = a[l++];
        }


        // 将数组拷贝回a
        for (int i = s; i < e + 1; i++) {
            a[i] = tempArray[i - s];
        }

    }


    private static void printSortResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    public static void main(String[] args) {
        System.out.println("归并排序");
        int N = 20;
        int[] testData = new int[N];
        for (int i = 0; i < N; i++) {
            testData[i] = new Random().nextInt(N) + 1;
        }
        long start = System.currentTimeMillis();
        sortPrice(testData, 0, testData.length - 1);
        printSortResult(testData);
        long end = System.currentTimeMillis();
        System.out.println("归并排序耗时 time = " + (end - start));
    }


    /**
     * 练习逻辑
     *
     * @param a
     * @param start
     * @param end
     */
    public static void sortPrice(int[] a, int start, int end) {
        if (end <= start) return;
        int m = (start + end) / 2;
        sortPrice(a, start, m);
        sortPrice(a, m + 1, end);
        merge(a, start, end, m);

    }


}
