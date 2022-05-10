package sortreview;

import java.util.Arrays;

/**
 * 归并排序（从小到大）
 *
 * @author whoo
 * @create 2022-05-10 15:25
 */
public class mergeSort {

    public static void main(String[] args) {
        int[] arr = {3, -1, 5, 1, 0, 33, -7, 2, 8};
//        int[] arr = {8,4,5,7,1,2,-6,3,6,2,0};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high, int[] temp){

        if(low < high){

            int mid = (low + high) / 2;

            mergeSort(arr, low, mid, temp);
            mergeSort(arr, mid+1, high, temp);

            merge(arr, low, mid, high, temp);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high, int[] temp) {

        int i = low;
        int j = mid + 1;
        int t = 0;

        //1.先将两个数组的数值进行比较，数值小的按顺序填充进temp中
        while (i <= mid && j <= high) {

            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //2.将剩余的数组中的数据填充进temp中
        while(i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }

        while(j <= high){
            temp[t] = arr[j];
            t++;
            j++;
        }

        //3.将temp中的数组copy到arr中
        int arrTemp = low;
        t = 0;

        while(arrTemp <= high){
            arr[arrTemp] = temp[t];
            arrTemp++;
            t++;
        }
    }
}