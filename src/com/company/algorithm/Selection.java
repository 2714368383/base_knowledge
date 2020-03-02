package com.company.algorithm;

import java.util.Random;

/**
 * 选择排序
 * 1 区分排序区间和未排序区间
 * 2 从未排序区间中找到最小的元素放在排序区间的第一个元素位置
 * 3 第一次排序区间元素为0
 */
public class Selection {


    public static int[] select(int[] a) {
        int n = a.length;
        // 一个数据
        if (n <= 0) return a;
        for (int i = 0; i < n; i++) {
            // 每轮小的对比选出最小值和最小值的序列号
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 将筛选的最小的值和有序区的最后一个元素进行交换
            // 进行数据的交换
            exchangeEle(a, minIndex, i);
        }
        return a;
    }


    /**
     * 优化选择排序
     * 一次行选择除最大和最小值放在指定的位置
     */

    public static int[] selectBetter(int[] a) {
        int n = a.length;
        for (int left = 0, right = n - 1; left < right; right--, left++) {
            int minIndex = left;
            int maxIndex = right;
            for (int i = left + 1; i < right; i++) {
                if (a[maxIndex] < a[i]) {
                    maxIndex = i;
                }
                if (a[minIndex] > a[i]) {
                    minIndex = i;
                }
            }
            if (maxIndex == minIndex) break;
            // 进行大小数据的交换
            exchangeEle(a, left, minIndex);
            exchangeEle(a, right, maxIndex);
        }
        return null;
    }


    public static void exchangeEle(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }


    public static void main(String[] args) {


        int length = 100000;
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = new Random().nextInt(length) + 1;
        }


        long startA = System.currentTimeMillis();
        select(a);
//        printSortResult(a);
        long endA = System.currentTimeMillis();
        System.out.println("A time = " + (endA - startA));


        long startB = System.currentTimeMillis();
        selectBetter(a);
//        printSortResult(a);
        long endB = System.currentTimeMillis();
        System.out.println("B time = " + (endB - startB));

    }

    private static void printSortResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
