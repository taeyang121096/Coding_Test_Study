import java.util.*;
public class Gita {
//    p = 현재 볼륨 i = p+v[i] or p - v[i], 0<= <=m, n = 곡 개수 s = 시작 볼륨
//    n = 3 s = 5 m = 10
//    v[1] = 5 v[2] = 3 v[3] = 7
//    dp[1] = 0, 10 dp[2] = 3, 7, dp[3] = 10, 0

    
     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int[] dis = new int[n+1];
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][s] = true;
        
        for(int i = 1;i<=n;i++) {
            dis[i] = sc.nextInt();
        }
        
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=m;j++){
                if(!dp[i-1][j]) {
                    continue;
                }
                if(j+dis[i] <=m){
                    dp[i][j+dis[i]] = true;
                }
                if(j-dis[i] >=0){
                    dp[i][j-dis[i]] = true;
                }
            }
        }
        
        for(int i = m;i>=0;i--){
            if(dp[n][i]) {
                System.out.println(i);
                System.exit(1);
            }
        }
         System.out.println(-1);

    }
}
