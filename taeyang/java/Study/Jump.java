import java.util.*;
import java.io.*;

public class Jump {

    static int[][] mat;
    static long[][] dp;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        mat = new int[n][n];
        dp = new long[n][n];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0;j<n;j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 0 || (i == n-1 && j == n-1))
                    continue;
                int cost = mat[i][j];
                if(i + cost <n){
                    dp[i+cost][j] += dp[i][j];
                }
                if(j + cost <n){
                    dp[i][j+cost] += dp[i][j];
                }
            }
        }
        System.out.println( dp[n-1][n-1]);


    }
}
