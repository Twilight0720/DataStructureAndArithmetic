package sort;

import java.util.Arrays;

/**
 * @author whoo
 * @create 2022-05-09 13:52
 */
public class QuickSortReview {

    public static void main(String[] args) {
//        int[] arr = {-9, 78, 0, 23, -567, 70};
//        int[] arr = {-5, -8, -1, 0, 9, 0, 7, 6};
//        int[] arr = {15, -8, -1, 0, 9, 0, 7, 7, 6};

//        quickSort(arr, 0, arr.length-1);
//        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        int[] arr = new int[10000000];
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            arr[i] = (int) (Math.random() * 1000000000);//生成一个[0，10000000)数
        }
        //测试快排
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("执行时间：" + (end - start));
    }

    /**
     * 从小到大快速排序
     * @param arr 排序数组
     * @param low 数组最左边
     * @param high 最右边
     */
    public static void quickSort(int[] arr, int low, int high){

        //判断是否越界，当出现越界则说明已经递归完成
        if(low >= high){
            return;
        }

        int base = arr[low];//基准值
        int i = low;//遍历比基准值小的指针
        int j = high;//遍历比基准值大的指针
        int temp;//保存临时变量的指针

        /*一次循环，直到i==j也就是找到基准值归位的位置为止*/
        while(i < j){

            //先向左移动j，直到找到比基准值小的值为止
            //同时需要保证 i<j恒成立
            while(i < j && arr[j] <= base){
                j--;
            }

            //再向右移动i，直到找到比基准值大的值为止
            //同时需要保证i<j恒成立
            while(i < j && arr[i] >= base){
                i++;
            }

            //经过了前面两个while循环，找到了符合条件的值，交换
            //需要保证满足i<j的条件
            /*有一种特殊情况，万一基准值选到了最大的数，这时候必定会出现i==j
              这时候进行交换没什么必要，加入判断条件if(i < j)可以提高效率*/
//            if(i < j){
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
//            }
        }

        /*while循环结束，说明i == j 就碰面了，这时候可以把基准值与i == j对应的数组值交换
          也即基准值归位*/
        arr[low] = arr[j];
        arr[j] = base;

        /*一次交换结束*/
        //向左递归
        quickSort(arr, low, j-1);
        //向右递归
        quickSort(arr, j+1, high);
    }
}
