package sort;

import java.util.Arrays;

/**
 * @author whoo
 * @create 2022-05-09 15:11
 */
public class MergeSortReview {

    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,2,-6,3,6,2,0};
        int[] temp = new int[arr.length];//归并排序需要一个额外的空间
        mergeSort(arr, 0, arr.length-1, temp);

        System.out.println("归并排序后：" + Arrays.toString(arr));

//        int[] arr = new int[10000000];
//        int[] temp = new int[10000000];
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10000000; i++) {
//            arr[i] = (int)(Math.random() * 1000000000);//生成一个[0，10000000)数
//        }
        //测试shell排序
//        mergeSort(arr, 0, arr.length-1, temp);
//        long end = System.currentTimeMillis();
//        System.out.println("排序后：" + Arrays.toString(arr));
//        System.out.println("执行时间：" + (end - start));
    }

    public static void mergeSort(int[] arr, int low, int high, int[] temp){

        if(low < high){

            int mid = (low + high) / 2;
            //左边递归
            mergeSort(arr, low, mid, temp);
            //右边递归
            mergeSort(arr, mid+1, high, temp);

            merge(arr, low, mid, high, temp);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high, int[] temp){

        int i = low;
        int j = mid + 1;
        int t = 0;

        while(i <= mid && j <= high){

            //分别比较并填充至temp钟
            if(arr[i] < arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else{
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //只会有一个数组没有全部填充到temp钟
        while(i <= mid){
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while(j <= high){
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //将temp中的数值全部copy回arr中
        int arrTemp = low;
        t = 0;//重置
        while(arrTemp <= high){
            arr[arrTemp] = temp[t];
            t += 1;
            arrTemp += 1;
        }
    }
}
