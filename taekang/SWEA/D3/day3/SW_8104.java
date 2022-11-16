package SWEA.D3.day3;

import java.io.*;
import java.util.*;

public class SW_8104 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int K = Integer.parseInt(str[1]);

            int sum = 0;
            for (int i = 1; i <= N; i++) {
                if (i % 2 != 0) {
                    sum += (i - 1) * K + 1;
                } else {
                    sum += i * K;
                }
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < K; i++) {
                if (N % 2 != 0) {
                    System.out.print(sum + i + " ");
                } else {
                    System.out.print(sum + " ");
                }
            }
            System.out.println();
        }
    }
}
