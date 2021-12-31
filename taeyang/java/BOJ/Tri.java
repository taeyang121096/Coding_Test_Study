package basic;

import java.io.*;
import java.util.*;
public class Tri {

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][]arr = new int[n+1][n+1];
        int[][]dp = new int[n+1][n+1];
        for(int i = 1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int index = 1;
            while(st.hasMoreTokens()){
                arr[i][index++] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = arr[1][1];
        for(int i = 2;i<=n;i++){
            for(int j = 1;j<=i;j++)
                dp[i][j] = Math.max(dp[i-1][j-1]+arr[i][j],dp[i-1][j]+arr[i][j]);
        }
        System.out.println(Arrays.stream(dp[n]).max().getAsInt());
    }
}
