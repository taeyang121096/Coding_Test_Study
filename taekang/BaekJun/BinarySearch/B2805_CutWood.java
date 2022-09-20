package BaekJun.BinarySearch;

import java.io.*;
import java.util.*;

public class B2805_CutWood {
    public static void main(String[] args) throws IOException {
        /**
         * 나무 M 미터가 필요, 절단기 높이 H 지정, 높이를 지정하면 톱날이 H 미터 위로 올라감
         * 그 다음 연속한 나무 절단. 높이의 최댓값
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split(" ");
        int N = Integer.parseInt(str[0]); // 4
        int M = Integer.parseInt(str[1]); // 7
        int[] arr = new int[N];
        String[] a = br.readLine().trim().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(a[i]);
        }
        Arrays.sort(arr); // 10 15 17 20
        // H 를 거꾸로 ? 자르기?
        int min = 0;
        int max = arr[N - 1]; // 20
        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;

            for (int treeHeight : arr) {
                if (treeHeight - mid > 0) {
                    sum += (treeHeight - mid);
                }
            }
            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

//        for (int i = H; i > 0; i--) {
//            int sum = 0;
//            for (int j = N - 1; j >= 0; j--) {
//                if (arr[j] >= i) {
//                    sum += arr[j] - i;
//                    if (sum == M) {
//                        if (max < i) {
//                            max = i;
//                        }
//                        break;
//                    }
//                }
//            }
//        }
        System.out.println(min-1);
    }
}
