package basic;
import java.util.*;
public class LongSub {

    static int[] number;
    static int[] dp;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] num = sc.nextLine().split(" ");
        number = new int[n];
        dp = new int[n];
        for(int i = 0;i<n;i++)
            number[i] = Integer.parseInt(num[i]);

        for(int i = 0;i<n;i++){
            dp[i] = 1;

            for(int j = 0;j<i;j++){
                if(number[i]>number[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}
