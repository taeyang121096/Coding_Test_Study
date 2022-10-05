package BaekJun.BinarySearch;

import java.io.*;
import java.util.*;


public class B3649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine()) * 10000000;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int idx = -1;
        int mid_idx = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                int k = arr[i] + arr[mid];
                if (mid != i) {
                    if (k == X) {
                        if (max < Math.abs(arr[i] - arr[mid])) {
                            idx = i;
                            mid_idx = mid;
                            max = Math.abs(arr[i] - arr[mid]);
                        }
                        break;
                    } else if (k > X) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    left = mid + 1;
                }
            }
        }

        if (max == Integer.MIN_VALUE) {
            System.out.println("danger");
        } else {
            System.out.println("yes " + arr[idx] + " " + arr[mid_idx]);
        }
    }

}
