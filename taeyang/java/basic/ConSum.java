package basic;
import java.util.*;
import java.io.*;
public class ConSum {
    static int[] dp;
    static int[] num;
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int index = 0;
        while(st.hasMoreTokens()){
            num[index++] = Integer.parseInt(st.nextToken());
        }
        dp[0] = num[0];
        for(int i = 1;i<n;i++){
            if(dp[i-1] >=0)
                dp[i] += dp[i-1]+num[i];
            else
                dp[i] += num[i];
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
