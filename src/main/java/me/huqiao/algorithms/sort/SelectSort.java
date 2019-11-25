package me.huqiao.algorithms.sort;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {3,4,5,5,2,3,4,6,10};
        new SelectSort().sort(arr);
        SortUtil.print(arr);
        System.out.println(SortUtil.isSorted(arr));
    }

    public void sort(int[] arr) {
        sort(arr, 0, arr.length,1);
    }
    public void sort(int[] arr,int start,int end,int step){
        for(int i = start; i< end; i+=step){
            int minIndex = i;
            int min = arr[i];
            for(int j = i+step; j < end; j+=step){
                if(arr[j] < min){
                    minIndex = j;
                    min = arr[j];
                }
            }
            if(minIndex != i) {
                SortUtil.swap(arr, i, minIndex);
            }
            SortUtil.print(arr);
        }
    }







}
