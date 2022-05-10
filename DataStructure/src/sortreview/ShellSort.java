package sortreview;

import java.util.Arrays;

/**
 * shell排序（从小到大）
 * @author whoo
 * @create 2022-05-10 15:11
 */
public class ShellSort {

    public static void main(String[] args) {
//        int[] arr = {3,-1,5,1,0,33,-7,2,8};
//        shellSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[8000000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000000);
        }

        long start = System.currentTimeMillis();
        shellSort(arr);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr));
        System.out.println("程序执行时间：" + (end - start));
    }

    public static void shellSort(int[] arr){

        int insertIndex;
        int insertValue;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                insertIndex = i-gap;
                insertValue = arr[i];

                while(insertIndex >= 0 && arr[insertIndex] > insertValue){
                    arr[insertIndex+gap] = arr[insertIndex];
                    insertIndex -= gap;
                }

                if(insertIndex + gap != i){
                    arr[insertIndex + gap] = insertValue;
                }
            }
        }
    }
}
