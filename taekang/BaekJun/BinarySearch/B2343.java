package BaekJun.BinarySearch;

import java.io.*;
import java.util.*;

/**
 * 블루 레이에는 총 N 개의 강의가 들어가는데, 강의의 순서가 바뀌면 안됨.
 */
public class B2343 {
    public static int N, M;
    public static int[] arr, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];

        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int start = max;
        int end = 100000 * 10000;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (M > isCan(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }

    public static int isCan(int mid) { // XXX, 3
        int cnt = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum > mid) {
                sum = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}
