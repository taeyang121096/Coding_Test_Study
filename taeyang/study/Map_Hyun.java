import java.util.*;
import java.io.*;

public class Map_Hyun {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 2;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (int) Math.pow(2, i - 1);
        }

        System.out.print((int) Math.pow(dp[n], 2));
        // 2 -> 3 -> 5 -> 9 -> 17
        //     2+1  3 + 2 5 + 4
        // 1 -> 2 -> 3 -> 4 -> 5

    }
}

