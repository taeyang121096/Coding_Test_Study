package SWEA.D3.day2;

import java.io.*;
import java.util.*;

public class SW_12004 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    list.add(new int[]{i, num / i});
                }
            }
            boolean flag= false;
            for (int[] in : list) {
                if (in[0] <= 9 && in[1] <= 9) {
                    flag= true;
                    break;
                }
            }
            if(!flag) System.out.println("#" + tc + " No");
            else System.out.println("#" + tc + " Yes");
        }
    }
}
