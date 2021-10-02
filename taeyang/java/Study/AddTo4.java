import java.util.*;
public class AddTo4 {

// n 을 1,2,3 합으로 만든다
    static int[][] dp = new int[10001][4];
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;


        for(int i =4;i<=10000;i++){
            dp[i][1] = 1;
            for(int j = 2;j<=3;j++){
                for(int k = 1;k<=j;k++){
                    dp[i][j] += dp[i-j][k];
                }
            }


        }
        for(int i = 0;i<n;i++){
            int num = sc.nextInt();
            System.out.println(Arrays.stream(dp[num]).sum());
        }

    }
}
