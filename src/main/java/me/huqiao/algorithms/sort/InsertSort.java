package me.huqiao.algorithms.sort;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {3,4,5,5,2,3,4,6,10};
        new InsertSort().sort(arr);
        SortUtil.print(arr);
        System.out.println(SortUtil.isSorted(arr));
    }

    public void sort(int[] arr){
        //area less than i is sorted
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                int tmp = arr[j];
                int w = j;
                while(w > 0 && tmp < arr[w-1] ){
                    arr[w] = arr[w - 1];
                    w--;
                }
                arr[w] = tmp;
            }
        }
    }





}
