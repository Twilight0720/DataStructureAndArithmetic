package sortreview;

import java.util.Arrays;

/**
 * 冒泡排序(从小到大)
 *
 * @author whoo
 * @create 2022-05-10 14:45
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[100000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000000);
        }

        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr));
        System.out.println("程序执行时间：" + (end - start));
    }

    public static void bubbleSort(int[] arr) {

        boolean flag = false;
        int temp;

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
