package me.huqiao.algorithms.sort;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {3,4,5,5,2,3,4,6,10};
        new ShellSort().sort(arr);
        SortUtil.print(arr);
        System.out.println(SortUtil.isSorted(arr));
    }

    public void sort(int[] arr){
        int step = arr.length / 2;
        SelectSort selectSort = new SelectSort();
        while(step > 0){
            for(int i = 0;i<step;i++){
                selectSort.sort(arr,i,arr.length,step);
            }
            step /=2;
        }

    }





}
