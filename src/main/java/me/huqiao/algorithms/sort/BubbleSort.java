package me.huqiao.algorithms.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3,4,5,5,2,3,4,6,10};
        new BubbleSort().sort(arr);
        SortUtil.print(arr);
        System.out.println(SortUtil.isSorted(arr));
    }

    public void sort(int[] arr){
        while(true){
            boolean exchanged = false;
            for(int i = 0;i<arr.length - 1;i++){
                if(arr[i] > arr[i+1]){
                    SortUtil.swap(arr,i,i+1);
                    exchanged = true;
                }
            }
            if(!exchanged){
                break;
            }
        }
    }





}
