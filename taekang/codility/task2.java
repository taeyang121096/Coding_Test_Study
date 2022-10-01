package codility;

import java.io.*;
import java.util.*;

public class task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 1;
        int K = 2;
        if (N >= K) {
            System.out.println(1);
            System.exit(0);
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + i;
        }

        int sum = 0;
        int cnt = 0;
        boolean flag = false;
        for (int i = N; i >= 1; i--) {
            if (sum + i <= K) {
                sum += i;
                cnt++;
            }
            if (sum == K) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
//        int cnt = 0;
//        while(true){
//            if(K - dp[N] > 0){
//                cnt++;
//            }
//        }
//        int k = 1;
//        int cnt = 0;
//        boolean flag= false;
//        while (true) {
//            K -= dp[k];
//            k++;
//            if (K == 0) {
//                flag= true;
//                k = cnt;
//                break;
//            }
//            if (K < 0) {
//                break;
//            }
//        }
//
//        if(flag){
//            System.out.println(cnt);
//        } else {
//            System.out.println(-1);
//        }
    }
}
