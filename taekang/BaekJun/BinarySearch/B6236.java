package BaekJun.BinarySearch;

import java.io.*;
import java.util.*;

public class B6236 {
    public static int N, M, result = 0;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        // 100 100 101 300 400 400 500

        int left = max;
        int right = 10_000 * 100_000;

        while (left <= right) {
            int mid = (left + right) / 2; // 돈
            if (M >= getWithdrawalCount(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    public static int getWithdrawalCount(int withdrawalAmount) {
        int cnt = 1;
        int M = withdrawalAmount; // 500

        // 100 100 101 300 400 400 500
        for (int i : arr) {
            M -= i;
            if (M < 0) {
                ++cnt;
                M = withdrawalAmount - i;
            }
        }

        return cnt;
    }
}
