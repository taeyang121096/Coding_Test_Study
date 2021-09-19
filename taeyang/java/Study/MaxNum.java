import java.util.*;
public class MaxNum {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int j = 0;j<t;j++) {
            Integer[] arr = new Integer[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr,Collections.reverseOrder());
            System.out.println(arr[2]);
        }
    }
}
