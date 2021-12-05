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
        dp[1][0] = arr[1];
        dp[1][1] = 0;
        for(int i = 2;i<n;i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i-1][0]);
        }
        int max = 0;
        max = Arrays.stream(dp).flatMapToInt(s->Arrays.stream(s)).max().getAsInt();
        System.out.println(max);

    }
}
