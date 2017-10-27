package sort;

/**
 * Created by garyhu
 * on 2017/9/13.
 * method: 插入排序
 * 描述：
 * 在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排
 * 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
 * 也是排好顺序的。如此反复循环，直到全部排好顺序。
 */
public class InsertSort {

    public static void main(String[] args){
        int[] arr = {48,39,13,56,87,98,10,28};
        InsertSort i = new InsertSort();
        i.insert(arr);
        Utils.print(arr);
    }

    public void insert(int[] array) {
        if(array.length<2){
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int position = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > currentValue) {
                    array[j + 1] = array[j];
                    position -= 1;
                } else {
                    break;
                }
            }

            array[position] = currentValue;
        }
    }
}
