import java.util.*;
public class Coin2 {
//    n가지 동전 가치의 합이 k 동전의 개수가 최소
    static int[] dp;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        dp = new int[k+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0] = 0;
        for(int i = 0;i<n;i++){
            int num = sc.nextInt();
            for(int j = num;j<k+1;j+=num) {
                dp[j]  = Math.min(dp[j],j/num);
                System.out.println(j);
            }
            for(int l = num+1;l<k+1;l++){
                if(dp[l-num] != Integer.MAX_VALUE)
                    dp[l] = Math.min(dp[l],dp[l-num]+1);
            }

        }

        if(dp[k] != Integer.MAX_VALUE)
            System.out.println(dp[k]);
        else
            System.out.println(-1);
        sc.close();
    }

}
