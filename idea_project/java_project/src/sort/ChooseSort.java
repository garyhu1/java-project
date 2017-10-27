package sort;

/**
 * Created by garyhu
 * on 2017/9/13.
 * method: 选择排序
 * 描述：
 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 */
public class ChooseSort {

    public static void main(String[] args){
        int[] arr = {48,39,13,56,87,98,10,28};
        ChooseSort c = new ChooseSort();
        c.chooseSort(arr);
        Utils.print(arr);
    }

    public void chooseSort(int[] arr){
        int position=0;
        for(int i=0;i<arr.length;i++){
            position=i;
            int temp=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<temp){
                    temp=arr[j];
                    position=j;
                }
            }
            arr[position]=arr[i];
            arr[i]=temp;
        }
    }
}
