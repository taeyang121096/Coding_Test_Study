package BaekJun;

import java.io.*;
import java.util.*;

public class B14888_Operation {
    static int[] arr, bag, result;
    static int n;
    static long max, min;
    static boolean[] visit;
    static List<Integer> optionList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 6

        arr = new int[n];
        visit = new boolean[n];
        result = new int[n - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 1 2 3 4 5 6
        }

        bag = new int[n - 1];
        optionList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            int cnt = Integer.parseInt(st.nextToken()); // 2 1 1 1
            for (int j = 0; j < cnt; j++) {
                optionList.add(i + 1); // 1 1 2 3 4 5
            }
        }

        for (int i = 0; i < n - 1; i++) {
            bag[i] = optionList.get(i); //
        }

        max = -1000000000;
        min = 1000000000;
        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth) {
        // 종료 조건
        if (depth == n - 1) {
            long sum = arr[0];
            for (int i = 0; i < n - 1; i++) {
                int x = result[i]; // 1 1 2 3 4

                if (x == 1) {
                    sum += arr[i + 1];
                } else if (x == 2) {
                    sum -= arr[i + 1];
                } else if (x == 3) {
                    sum *= arr[i + 1];
                } else {
                    if (sum < 0) {
                        sum = Math.abs(sum);
                        sum = -(sum / arr[i + 1]);
                    }else {
                        sum /= arr[i + 1];

                    }
                }
            }
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        // 실행 조건
        for (int i = 0; i < n - 1; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = bag[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
