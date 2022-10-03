package BaekJun.BinarySearch;

import java.io.*;
import java.util.*;

public class B2776 {
    public static int N, M;
    public static int[] arr1, arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            arr1 = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr1);

            M = Integer.parseInt(br.readLine());
            arr2 = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < M; i++) {
                if (i == M - 1) {
                    if (binarySearch(arr2[i])) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                } else {
                    if (binarySearch(arr2[i])) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                }

            }
            System.out.println(sb.toString());
        }
    }

    public static boolean binarySearch(int num) {
        int start = 0;
        int end = N - 1;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr1[mid] < num) {
                start = mid + 1;
            } else if (arr1[mid] > num) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
