package codility.softeer_bootcamp;

import java.io.*;
import java.util.*;

public class Solution2 {
    public static int N, M;
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        String[] split = s[2].split(",");

        // M을 N-1 번
        int pow = 1;
        for (int i = 0; i < N - 1; i++) {
            pow *= M;
        }

        int[] arr = new int[pow];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        dfs(arr, arr.length, N, N);
        Collections.sort(list);
        for (int in : list) {
            System.out.println(1 + Integer.toString(in, 2));
        }
    }

    private static void dfs(int[] arr, int length, int depth, int N) {
        if (depth == 1) {
            return;
        }

        int[] ans = new int[length / M];

        for (int i = 0; i < arr.length; i += M) { // 0 2 4 6
            if (arr[i] == 1 && arr[i + 1] == 0) {
                list.add(i + 1);
                ans[i / M] = 1;
            } else if (arr[i] == 0 && arr[i + 1] == 1) {
                list.add(i);
                ans[i / M] = 1;
            }
        }

        dfs(ans, ans.length, depth - 1, N / 2);
    }
}
