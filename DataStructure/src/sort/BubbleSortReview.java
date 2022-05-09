package sort;

import java.util.Arrays;

/**
 * @author whoo
 * @create 2022-05-07 16:25
 */
public class BubbleSortReview {

    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,2,20,-8,-2,3};
        System.out.println("排序前：" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){

        int temp;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(flag == false){
                System.out.println(count);
                break;
            }else{
                count++;
                flag = false;
            }
        }
    }
}
