package sort;

/**
 * Created by garyhu
 * on 2017/9/13.
 * method:
 */
public class Utils {

    public static void print(int[] arr){
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
}
