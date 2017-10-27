package sort;

/**
 * Created by garyhu
 * on 2017/9/13.
 * method:  快速排序算法，从键盘输入一组整数数组，用快速排序输出排序后的结果
 *
 * ************************************ start **************************************************
 *
 * 输入描述：请输入要排序的数组：
 *           48 15 24 59 64 79 97 40
 * 程序输出： 48 15 24 59 64 79 97 40
 *           输入的数组是：
 *           48 15 24 59 64 79 97 40
 *           排序后的数组是：
 *           15 24 40 48 59 64 79 97
 *           第二种写法的输出：
 *           排序后的数组是：
 *           15 24 40 48 59 64 79 97
 * 问题分析：1.从键盘输入一个整数字符串，将字符串转化为整数数组
 *           解决方法：先将字符串用str.split()转化为字符串数组，再将字符串数组转化为整数数组
 * 算法描述：实现快速排序算法的关键在于现在数组中选择一个数字，接下来把数组中的数字分为两部分，比选择的数字小的数字移到数组左边，
 *           比选择的数字大的数字移到数组的右边。
 *           1.  设要排序的数组是A[0]……A[N-1]，首先任意选取一个数据（通常选用第一个元素）作为基准点，然后将所有比它小的数都放到它前面，
 *           所有比它大的数都放到它后面，这个过程称为一趟快速排序，然后采用分治策略，分别以同样的方式排序前面和后面的数据。
 *           2.一趟快速排序的算法是：
 *           1）设置两个变量i、j，排序开始的时候：i=0，j=N-1；
 *           2）以第一个数组元素作为基准点。
 *           3）从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于A[i](此时基准点)的值A[j]，将值与A[j]交换；
 *           4）从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于A[j]（此时基准点）的A[i]，将A[j]与A[i]交换；
 *           5）循环执行第3、4步，直到i=j;
 *           6）到此找到基准点的下标，作为分治下标。
 *           7)重复1-6步骤递归排序前半部分
 *           8 )重复1-6步骤递归排序后半部分
 *
 ****************************************** over ****************************************************************
 *
 */
public class QuickSort {

    public static void main(String[] args){
        int[] arr = {48,15,24,59,79,64,97,40};
        QuickSort q = new QuickSort();
        q.quickSort(arr,0,arr.length-1);
        q.print(arr);
    }

    public void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(i==0){
                System.out.print("<<"+arr[i]+",");
            }else if(i==arr.length-1){
                System.out.print(arr[i]+">>");
            }else {
                System.out.print(arr[i]+",");
            }
        }
    }

    public void quickSort(int[] arr,int start,int end){
        if(arr.length<=1){//数组的元素就一个或者没有元素时，无需排序
            return;
        }
        if(start>=end){//起始位置和结束位置相同时或者大于时，结束递归的判断
            return;
        }
        int i = start;
        int j = end;
        //取基准值
        int key = arr[i];
        //设置一个标志用于判断是移动i还j，为false则移动下表i,为true时移动j
        boolean flag = true;
        //循环判断数组，当i=j时跳出循环
        while(i!=j){
           if(flag){//基准值与下标为j的数值进行比较
               if(key>arr[j]){//比基准值小就向左移动
                   swap(arr,i,j);
                   flag = false;
               }else {
                   j--;
               }
           }else {
               if(key<arr[i]){
                   swap(arr,i,j);
                   flag = true;
               }else {
                   i++;
               }
           }
        }

        quickSort(arr,start,j-1);
        quickSort(arr,i+1,end);
    }

    public void swap(int[] arr,int i,int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
