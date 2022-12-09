package Programmers.lv1;

import java.util.*;

public class SelectOrange {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        int max = Arrays.stream(tangerine).max().getAsInt();
        int[] arr = new int[max];
        Integer[] ans_arr = new Integer[arr.length];

        for (int i = 0; i < tangerine.length; i++) {
            arr[tangerine[i] - 1]++;
        }

        for (int i = 0; i < arr.length; i++) {
            ans_arr[i] = arr[i];
        }

        // 정렬 진행
        Arrays.sort(ans_arr, Comparator.reverseOrder());

        int idx = 0;

        while (k != 0) { // 2
            if (ans_arr[idx] == 0) {
                idx++; // 1
            }
            ans_arr[idx]--; //
            k--;
        }

        System.out.println(idx+1);
    }
}
