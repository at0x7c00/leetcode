package me.huqiao.algorithms.sort;

public class SortUtil {
    public static void swap(int[] arr,int i,int j){
        if(i == j){
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void print(int[] arr){
        for(int i : arr){
            System.out.print(i+",");
        }
        System.out.println();
    }
    public static boolean isSorted(int[] arr){
        for(int i = 0;i<arr.length - 1;i++){
            if(arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }
}
