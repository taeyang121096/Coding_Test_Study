package codility;

import java.io.*;
import java.util.*;

public class task1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int K = 16; int L = 16;
//        int i = K & L; // 비트 연산자
//        System.out.println(i);
        int[] A = new int[]{13,7,2,8,3};
        int ans = Integer.MIN_VALUE;
        /**
         *
         */

        for (int i = 0; i < 30; i++) {
            int cnt = 0;
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & (int)Math.pow(2, i)) > 1) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
