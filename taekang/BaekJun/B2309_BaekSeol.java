package BaekJun;

import java.io.*;
import java.util.*;

public class B2309_BaekSeol {
    static int arr[];

    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9];

        isUsed = new boolean[9];

        for (int i = 0; i < 9; i++) {
            int T = Integer.parseInt(br.readLine());
            arr[i] = T;
        }

        // 정렬 됨
        Arrays.sort(arr);

        find(9, 7, 0, arr, 0);
    }

    public static void find(int N, int M, int index, int[] arr, int sum) {
        if (M == index) {
            if (sum == 100) {
                for (int i = 0; i < 9; i++) {
                    if (isUsed[i])
                        System.out.print(arr[i]+ " ");
                }
                System.exit(0);
            }
            return;
        }

        if (index > N) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                find(N, M, index + 1, arr, sum + arr[i]);
                isUsed[i] = false;
            }
        }
    }
}