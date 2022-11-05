package SWEA.D3.day2;

import java.io.*;
import java.util.*;

public class SW_13038 {
    //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int T = Integer.parseInt(br.readLine());
//        for (int t = 1; t <= T; t++) {
//            // a1 a2 a3 a4 a5 a6 a7
//            int N = Integer.parseInt(br.readLine());
//
//            int[] arr = new int[7];
//            int cnt = 0;
//            int idx = Integer.MAX_VALUE;
//            String[] str = br.readLine().split(" ");
//            for (int i = 0; i < 7; i++) {
//                arr[i] = Integer.parseInt(str[i]);
//                if (arr[i] == 1) {
//                    cnt++;
//                    idx = Math.min(idx, i);
//                }
//            }
//            if (cnt == N) {
//                System.out.println("#" + t + " " + (idx + 1));
//                continue;
//            }
//
//            // 시작 일을 정해서 해야함
//            int sum = 0;
//            while (true) {
//                if (N > cnt) {
//                    N -= cnt;
//                    sum += 7;
//                } else {
//                    for (int i = idx; i < idx+N; i++) {
//                        if (arr[i] == 1) {
//                            sum++;
//                        }
//                    }
//                    N -= cnt;
//                }
//                if (N <= 0) break;
//            }
//            System.out.println("#" + t + " " + sum);
//        }
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // a1 a2 a3 a4 a5 a6 a7
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[7];
            int cnt = 0;
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < 7; i++) {
                arr[i] = Integer.parseInt(str[i]);
                if (arr[i] == 1) {
                    cnt++;
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 7; i++) {
                if (arr[i] == 0) continue;
                int start = i;
                int count = 0;
                while (true) {
                    if (arr[start % 7] == 1) count++;
                    start++;
                    if (count == N) {
                        min = Math.min(min, start - count - 1);
                        break;
                    }
                }

            }

            System.out.println("#" + t + " " + min);
        }

    }
}
