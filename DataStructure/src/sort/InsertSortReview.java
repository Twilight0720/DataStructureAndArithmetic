package sort;

import java.util.Arrays;

/**
 * @author whoo
 * @create 2022-05-07 17:06
 */
public class InsertSortReview {

    public static void main(String[] args) {
        int[] arr =  {101, 34, 119, 1, -8, 3};
        System.out.println("排序前：" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){

        int insertIndex;
        int insertValue;

        for (int i = 1; i < arr.length; i++) {

            insertValue = arr[i];
            insertIndex = i-1;
            while(insertIndex >= 0 && arr[insertIndex] < insertValue){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }

            if(insertIndex+1 != i){
                arr[insertIndex+1] = insertValue;
            }
        }
    }

}
