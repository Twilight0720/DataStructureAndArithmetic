package sortreview;

import java.util.Arrays;

/**
 * 快速排序（从小到大）
 * @author whoo
 * @create 2022-05-10 15:26
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] arr = {3,-1,5,1,0,33,-7,2,8};
//        quickSort(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[8000000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000000);
        }

        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr));
        System.out.println("程序执行时间：" + (end - start));
    }

    public static void quickSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int base = arr[low];
        int i = low;
        int j = high;
        int temp;

        while (i < j) {

            while (i < j && arr[j] >= base) {
                j--;
            }

            while (i < j && arr[i] <= base) {
                i++;
            }

            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //在一轮交换中，base左边全部都是小于base的值，base右边全部都是大于base的值
        //这时候可以将base归位了
        arr[low] = arr[j];
        arr[j] = base;

        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }
}
