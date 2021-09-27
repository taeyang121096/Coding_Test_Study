import java.util.*;
public class Coin {
//    중복 조합 n 종류 k원 경우의수를 구하라

    static int ans = 0;
    static int[] arr;
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        arr = new int[k+1];
        arr[0] = 1;
        for(int i = 0;i<n;i++){
            int num = sc.nextInt();
            for(int j = num;j<k+1;j++){
                arr[j] += arr[j-num];
            }
        }
        System.out.println(arr[k]);
    }
}
