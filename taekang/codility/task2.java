package codility;

import java.io.*;
import java.util.*;

public class task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 5;
        int K = 8;
        if (N >= K) {
            System.out.println(1);
            System.exit(0);
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
