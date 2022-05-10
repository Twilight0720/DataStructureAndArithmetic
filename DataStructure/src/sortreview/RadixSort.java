package sortreview;

import java.util.Arrays;

/**
 * 基数排序（从小到大）
 * @author whoo
 * @create 2022-05-10 16:11
 */
public class RadixSort {

    public static void main(String[] args) {
        long[] arr = {3, -1, 51, 1, 0, 33, -7, 2, 8, -11, -177};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(long[] arr){

        //求数组中最大数和最小数
        long max = arr[0];
        long min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }

            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(min);

        int maxLength;
        if(!"-".equals(String.valueOf(max).charAt(0))){
            maxLength = String.valueOf(max).length();
        }else{
            maxLength = String.valueOf(max).length()-1;
        }

        int minLength;
        if(!"-".equals(String.valueOf(min).charAt(0))){
            minLength = String.valueOf(min).length();
        }else{
            minLength = String.valueOf(min).length()-1;
        }

        int length;
        if(maxLength > minLength){
            length = maxLength;
        }else{
            length = minLength;
        }

        //桶
        long[][] bucket = new long[19][arr.length];
        //桶的计数器（计算各个桶中元素的个数）
        int[] bucketEleCounts = new int[19];

        for (int i = 0, n = 1; i < length; i++, n *= 10) {

            for (int j = 0; j < arr.length; j++) {

                int digitOfElement = (int) arr[j] / n % 10;
                //放到对应的桶中
                bucket[digitOfElement+9][bucketEleCounts[digitOfElement+9]] = arr[j];
                bucketEleCounts[digitOfElement+9]++;
            }

            int index = 0;
            for (int k = 0; k < bucketEleCounts.length; k++) {

                if(bucketEleCounts[k] != 0){

                    for (int l = 0; l < bucketEleCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketEleCounts[k] = 0;
            }
        }
    }
}
