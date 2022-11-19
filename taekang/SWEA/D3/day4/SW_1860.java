package SWEA.D3.day4;

import java.io.*;
import java.util.*;

public class SW_1860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // 3 4
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 2
            int M = Integer.parseInt(st.nextToken()); // 2
            int K = Integer.parseInt(st.nextToken()); // 2
            int[] arr = new int[N];
            // 2 초를 들이면 2개를 만들수 있는데,
            // 3초 4초에 도착한다.

            String[] str = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(str[i]); // 3
                arr[i] = num;
            }
            System.out.print("#" + tc + " ");
            int[] bread = new int[100]; // 0 1 2 3 4 5 6
            int sum = 0;
            Arrays.sort(arr);

            if (M > arr[0]) {
                System.out.println("Impossible");
            } else {
                boolean flag = true;
                int idx = 1;
                for (int j = 0; j < arr.length; j++) {
                    int basic = arr[j]; //
                    for (int i = idx; i < bread.length; i++) {
                        if (i % M == 0) {
                            sum += K;
                        }
                        bread[i] = sum;
                        if (basic == i) {
                            if (bread[i] <= 0) {
                                flag = false;
                                idx = i + 1;
                                break;
                            } else {
                                idx = i + 1;
                                break;
                            }
                        }
                    }
                }
                if (!flag) System.out.println("Impossible");
                else System.out.println("Possible");
            }
        }
    }
}