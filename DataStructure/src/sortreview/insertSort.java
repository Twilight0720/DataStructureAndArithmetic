package sortreview;

import java.util.Arrays;

/**
 * 插入排序(从小到大)
 * @author whoo
 * @create 2022-05-10 14:58
 */
public class insertSort {

    public static void main(String[] args) {
//        int[] arr = {3,-1,5,1,0,33,-7,2,8};
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[100000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000000);
        }

        long start = System.currentTimeMillis();
        insertSort(arr);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr));
        System.out.println("程序执行时间：" + (end - start));
    }

    public static void insertSort(int[] arr){

        int insertIndex;
        int insertVal;

        for (int i = 1; i < arr.length; i++) {

            insertIndex = i - 1;
            insertVal = arr[i];

            while(insertIndex >= 0 && arr[insertIndex] > insertVal){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }

            if(insertIndex+1 != i){
                arr[insertIndex+1] = insertVal;
            }
        }
    }
}
