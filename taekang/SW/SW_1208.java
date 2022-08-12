package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

public class SW_1208 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[100];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            for (int j = 0; j < n; j++) { // 834번 동안
                int max_idx = findMax(arr);
                int min_idx = findMin(arr);
                arr[max_idx]--;
                arr[min_idx]++;
            }

            int max_idx = -1;
            int min_idx = -1;
            for (int i = 0; i < 100; i++) { //max 인덱스와 min 인덱스 구해주고
                // 최댓값 최솟값 구하고, 최댓값에서 최솟값 뺴줌
                max_idx = findMax(arr);
                min_idx = findMin(arr);
            }
            System.out.println("#" + test_case + " " + (arr[max_idx] - arr[min_idx]));
        }
    }

    public static int findMax(int[] arr) {
        int idx = -1;
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }

    public static int findMin(int[] arr) {
        int idx = -1;
        int min = 101;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                idx = i;
            }
        }
        return idx;
    }
}
