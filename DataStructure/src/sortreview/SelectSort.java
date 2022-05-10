package sortreview;

import java.util.Arrays;

/**
 * 从小到大选择排序
 *
 * @author whoo
 * @create 2022-05-10 14:51
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[100000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000000);
        }

        long start = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr));
        System.out.println("程序执行时间：" + (end - start));
    }

    public static void selectSort(int[] arr) {

        int index;
        int min;

        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            index = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }

            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }
}
