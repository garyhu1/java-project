package sort;

/**
 * Created by garyhu
 * on 2017/9/13.
 * method: 冒泡排序
 * 描述：
 *  1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 *  2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 *  3、针对所有的元素重复以上的步骤，除了最后一个。
 *  4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] arr = {48,39,13,56,87,98,10,28};
        BubbleSort b = new BubbleSort();
        b.bubbleSort(arr);
        b.print(arr);
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

    public void bubbleSort(int[] arr){
        int temp;
        //控制循环次数
        for (int i = 0; i < arr.length-1; i++) {
            //控制相邻两数的比较次数
            for (int j = arr.length-1; j > i ; j--) {
                if(arr[j-1]>arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
