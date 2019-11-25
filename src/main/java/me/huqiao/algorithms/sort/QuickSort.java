package me.huqiao.algorithms.sort;

import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {0,3,4,5,5,10,2,3,4,6};
        new QuickSort().sort(arr,0,arr.length - 1);
        SortUtil.print(arr);
        System.out.println(SortUtil.isSorted(arr));
    }

    public void sort(int[] arr,int start,int end){
        //递归结束条件
        if(start >= end){
            return;
        }

        //主要逻辑
        int p = arr[end];//最后一个元素作为分隔点
        int j = start;//j永远指向第一个大于分隔点的元素
        for(int i = start; i < end; i++){
            if(arr[i] < p){
                SortUtil.swap(arr, i, j);
                j++;
            }
        }
        SortUtil.swap(arr, end, j);//最后将分隔点与大于分隔点的元素进行交换

        //递归
        sort(arr,0,j-1);
        sort(arr,j+1,end);
    }

}
