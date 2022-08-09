package BaekJun;

import java.io.*;
import java.util.*;

public class B1920_findNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String input = br.readLine();
        String[] str = input.split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        // 1 2 3 4 5
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        String input1 = br.readLine();
        String[] str1 = input1.split(" ");

        for (int i = 0; i < M; i++) {
            if (binarySearch(arr, Integer.parseInt(str1[i]))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static boolean binarySearch(int[] arr, int n) {
        int start = 0;
        int end = arr.length - 1; // 4
        int mid; // 2
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] > n) {
                end = mid - 1;
            } else if (arr[mid] < n) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
