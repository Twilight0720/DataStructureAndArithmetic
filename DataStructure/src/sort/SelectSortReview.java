package sort;

import java.util.Arrays;

/**
 * @author whoo
 * @create 2022-05-07 16:43
 */
public class SelectSortReview {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -9, 77, 3};
        System.out.println("排序前：" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
    public static void selectSort(int[] arr){

        int temp;
        int index;

        for (int i = 0; i < arr.length - 1; i++) {
            temp = arr[i];
            index = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < temp){
                    temp = arr[j];
                    index = j;
                }
            }

            if(index != i){
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
