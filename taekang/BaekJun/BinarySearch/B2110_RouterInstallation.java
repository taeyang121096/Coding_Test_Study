package BaekJun.BinarySearch;

import java.io.*;
import java.util.*;

/**
 * 집 N 개가 수직선 위에 있다. 집 좌표는 x1,...,xn 집 여ㅓ러개가 같은 좌표를 가지진 x
 * 최대한 많은 곳에서 와이파이 설치
 */
public class B2110_RouterInstallation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); // 5
        int M = Integer.parseInt(str[1]); // 3
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[N - 1] - arr[0] + 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            int cnt = 1;
            int start = arr[0]; // 1

            for (int i = 1; i < N; i++) {
                if (start + mid <= arr[i]) {
                    cnt++;
                    start = arr[i];
                }
            }

            if (cnt < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }
}
