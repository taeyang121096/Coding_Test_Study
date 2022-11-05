package SWEA.D3.day2;

import java.io.*;
import java.util.*;

public class SW_11736 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int i = 1; i < num - 1; i++) {
                int a = arr[i-1];
                int b = arr[i];
                int c = arr[i+1];

                if ((a < b && b < c) || (a > b && b > c)) {
                    cnt++;
                }
            }

            System.out.println("#" + tc + " " + cnt);
        }
    }
}
