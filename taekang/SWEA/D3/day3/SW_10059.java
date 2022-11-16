package SWEA.D3.day3;

import java.io.*;
import java.util.*;

public class SW_10059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            String[] str = br.readLine().split("");
            int a = Integer.parseInt(str[0] + str[1]); // 7
            int b = Integer.parseInt(str[2] + str[3]); // 21
            System.out.print("#" + tc + " ");
            /**
             * 12가 넘는건 무조건 YY 이어야 함
             *
             * a > 12 and b > 12 -> NA
             *
             * a <= 12 and b > 12 -> MMYY
             * if(a==0) -> NA
             * else MMYY
             *
             * a > 12 and b <= 12 -> YYMM
             * if(b == 0) -> NA
             * else YYMM
             *
             * a <= 12 and b <= 12 -> "AMBIGUOUS"
             * if(a==0) YYMM
             * if(b==0) MMYY
             */
            if (a > 12 && b > 12) {
                System.out.println("NA");
            } else if (a <= 12 && b > 12) {
                if (a == 0) {
                    System.out.println("NA");
                } else
                    System.out.println("MMYY");
            } else if (a > 12 && b <= 12) {
                if (b == 0) {
                    System.out.println("NA");
                } else
                    System.out.println("YYMM");
            } else if (a <= 12 && b <= 12) {
                if (a == 0 && b != 0) {
                    System.out.println("YYMM");
                } else if (b == 0 && a != 0) {
                    System.out.println("MMYY");
                } else if (a==0 && b == 0){
                    System.out.println("NA");
                } else {
                    System.out.println("AMBIGUOUS");
                }
            }
        }
    }
}

