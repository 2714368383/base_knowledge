package com.company.algorithm;

import java.util.Random;

/**
 * 1 冒泡排序
 * 1.1 冒泡排序的解析
 * 冒泡排序分为大排序和小排序
 * 小排序分主要是相邻元素的对比和交换
 * 从第一个元素开始和相邻元素对比交换到最后一个元素
 * 每轮大排序会确定出一个该轮排序中的一个最大元素并放至到指定过得位置
 * 每轮大排序的循环都会缩小小排序的循环范围
 * 1.2 冒泡排序的特点
 * 原地排序  ：空间复杂度O(1)
 * 稳定排序：对比相等的元素不进行交换
 * 时间复杂度：
 * 最好的情况：O(n)
 * 最坏的情况：O(n^2)   !n  (n的阶乘)
 */
public class Bubbling {


    /**
     * 没有进行过优化的冒泡排序算法
     *
     * @param sourceNum
     * @return
     */
    public static int[] noOptimize(int[] sourceNum) throws InterruptedException {
        int n = sourceNum.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (sourceNum[j] > sourceNum[j + 1]) {
                    exchangeEle(sourceNum, j, j + 1);
                }
            }
        }
        return sourceNum;
    }


    //

    /**
     * 优化后的冒泡排序 在所有的排序过程中
     *
     * @param sourceNum
     * @return
     */
    public static int[] optimize(int[] sourceNum) {
        System.out.println("优化冒泡排序");
        long startTime = System.currentTimeMillis();
        // 排序数组的长度
        int n = sourceNum.length;
        for (int i = 0; i < n; i++) {
            // 当逆序度为 0 的时候进行跳出循环比对
            boolean flag = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if (sourceNum[j] > sourceNum[j + 1]) {
                    exchangeEle(sourceNum, j, j + 1);
                    flag = false;
                }
            }
            if (flag)
                break;
        }
        return sourceNum;
    }

    public static void exchangeEle(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static void printSortResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    //
    public static void main(String[] args) throws InterruptedException {

        System.out.println("冒泡排序");
        int N = 10000;
        int[] testData = new int[N];
        for (int i = 0; i < N; i++) {
            testData[i] = new Random().nextInt(N) + 1;
        }
        long startA = System.currentTimeMillis();
        noOptimize(testData);
        long endA = System.currentTimeMillis();
        System.out.println("bubbling time = " + (endA - startA));

        long startB = System.currentTimeMillis();
        optimize(testData);

        long endB = System.currentTimeMillis();
        System.out.println("bubbling plus time = " + (endB - startB));
    }
}
