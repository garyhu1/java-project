package sort;

/**
 * Created by garyhu
 * on 2017/9/13.
 * method: 希尔排序
 * 描述：
 * 算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，
 * 每组中记录的下标相差d.对每组中全部元素进行直接插入排序，
 * 然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。
 * 当增量减到1时，进行直接插入排序后，排序完成
 */
public class ShellSort {

    public static void main(String[] args){
        int[] arr = {48,39,13,56,87,98,10,28};
        ShellSort s = new ShellSort();
        s.shellSort(arr);
        Utils.print(arr);
    }

    public void shellSort(int[] arr){
        double d1=arr.length;
        int temp=0;
        while(true){
            d1= Math.ceil(d1/2);
            int d=(int) d1;
            for(int x=0;x<d;x++){
                for(int i=x+d;i<arr.length;i+=d){
                    int j=i-d;
                    temp=arr[i];
                    for(;j>=0&&temp<arr[j];j-=d){
                        arr[j+d]=arr[j];
                    }
                    arr[j+d]=temp;
                }
            }
            if(d==1)
                break;
        }
    }
}
