package BaekJun.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class B2529 {
    public static int K;
    public static String[] arr;
    public static boolean[] check;
    public static int[] choice;
    public static long max = Long.MIN_VALUE;
    public static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        arr = new String[K];
        check = new boolean[10];
        choice = new int[K + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            arr[i] = st.nextToken();
        }

        // 0~9 로 조합 만들기
        dfs(0, K + 1, 0);

        makeString(max);
        makeString(min);
    }

    private static void makeString(long num) {
        if (num / Math.pow(10, K) <= 1) {
            String s = String.valueOf(num);
            String tmp = "0";
            tmp += s;
            System.out.println(tmp);
        } else {
            System.out.println(String.valueOf(num));
        }
    }

    public static void dfs(int at, int depth, int idx) {
        if (idx == depth) {
            if (isValid()) {
                long n = 0;
                for (int i = 0; i < K + 1; i++) {
                    n += choice[i] * Math.pow(10, K - i);
                }
                max = Math.max(max, n);
                min = Math.min(min, n);
            }
            return;
        }

        for (int i = at; i < 10; i++) {
            if (!check[i]) {
                check[i] = true;
                choice[idx] = i;
                dfs(at, depth, idx + 1);
                check[i] = false;
            }
        }
    }

    public static boolean isValid() {
        for (int i = 0; i < K; i++) {
            if (arr[i].equals(">")) {
                if (!(choice[i] > choice[i + 1])) {
                    return false;
                }
            } else {
                if (!(choice[i] < choice[i + 1])) {
                    return false;
                }
            }
        }
        return true;
    }
}
