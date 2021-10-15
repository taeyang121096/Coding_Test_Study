import java.util.*;
import java.io.*;
public class Retire {

    static int[][] dp;
    static int ans = 0;
    static int n;
    static void dfs(int start,int sum){
        
        if(start > n){

            ans = Math.max(sum,ans);
            return;
        }
        if(start+dp[start][0] <= n+1) {
            dfs(start + dp[start][0], sum + dp[start][1]);
        }
        dfs(start+1,sum);

    }
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        dp = new int[n+1][2];
        for(int i = 1;i<=n;i++){
            st = new StringTokenizer(br.readLine()," ");
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(1,0);
        System.out.println(ans);

    }
}
