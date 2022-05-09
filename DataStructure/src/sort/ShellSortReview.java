package sort;

import java.util.Arrays;

/**
 * @author whoo
 * @create 2022-05-08 14:27
 */
public class ShellSortReview {

    public static void main(String[] args) {
//        int[] arr = {8,9,1,7,2,3,5,4,6,0};
//        shellSortTest(arr);

        int[] arr = new int[10000000];
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            arr[i] = (int)(Math.random() * 1000000000);//生成一个[0，10000000)数
        }
        //测试shell排序
        shellSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("执行时间：" + (end - start));
    }

    /**
     * 交换法结合希尔排序
     * @param arr
     */
    public static void shellSortTest(int[] arr){

        int temp;

        for (int gap = arr.length/2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {

                for (int j = i - gap; j >= 0; j -= gap) {
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }

    public static void shellSort(int[] arr){

        int temp;
        int insertIndex;

        for (int gap = arr.length/2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {

                insertIndex = i - gap;
                temp = arr[i];

                while(insertIndex >= 0 && arr[insertIndex] > temp){
                    arr[insertIndex+gap] = arr[insertIndex];
                    insertIndex -= gap;
                }

                if(insertIndex + gap != i){
                    arr[insertIndex+gap] = temp;
                }
            }

        }
    }
}
