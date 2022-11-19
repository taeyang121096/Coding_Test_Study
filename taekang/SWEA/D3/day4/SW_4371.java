package SWEA.D3.day4;

import java.io.*;
import java.util.*;

/**
 * 배가 한 척이라도 항구에 들른 날은 즐거운 날,
 * 주기적으로 들름, 주기가 3이면 1 4 7..ㅣ.
 */
public class SW_4371 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ArrayList<Integer> arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            boolean[] check = new boolean[N - 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                if (num != 1) arr.add(num);
            }
            // 1 | 3 4
            // 1 | 7 10 13 19
            // 1 | 5000000 99999999
            int start = 1;
            int ans = 0;
            // 10 13 19
            for (int i = 0; i < arr.size(); i++) {
                if(check[i]) continue;
                int ab = arr.get(i)- start; // 9
                ans += 1;
                for (int j = i + 1; j < arr.size(); j++) {
                    if ((arr.get(j) - 1) % ab == 0 && !check[j]) {
                        check[j] = true;
                    }
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}
