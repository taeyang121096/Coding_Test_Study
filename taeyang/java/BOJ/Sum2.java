package basic;
import java.util.*;
import java.io.*;
public class Sum2 {
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[n+1];
        int[][] dp = new int[n+1][2];
        for(int i = 1;i<=n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp[1][0] = 0;
        dp[1][1] = arr[1];
        int max = dp[1][1];
        for(int i = 2;i<n;i++) {
            dp[i][0] = Math.max(dp[i-1][0]+arr[i],dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-1][1]+arr[i],arr[i]);
            max = Math.max(dp[i][0],dp[i][1]);
        }
        System.out.println(max);

    }
}
