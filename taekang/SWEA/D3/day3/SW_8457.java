package SWEA.D3.day3;

import java.io.*;
import java.util.*;

/**
 * N 개의 모래시계, i 번째 모래시계는 정확히 xi 초 측정 가능
 * 2xi 3xi ... 는 측정이 가능하다, E초 정도의 오차를 허용하려고 함
 * B-E 초에서 B + E 초 중 하나를 측정해낼 수 있으면 된다.
 */
public class SW_8457 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);
            int E = Integer.parseInt(s[2]);
            // 8 <= 범위 <= 12
            // N = 3 -> 1,2,3
            String[] str = br.readLine().split(" ");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < str.length; i++) {
                list.add(Integer.parseInt(str[i]));
            }
            int ans = 0;
            for (int i = 0; i < N; i++) {
                int hourGlass = list.get(i);
                for (int j = B - E; j <= B + E; j++) {
                    if (j % hourGlass == 0) {
                        ans++;
                        break;
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
