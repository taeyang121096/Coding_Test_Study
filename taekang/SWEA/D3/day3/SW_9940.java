package SWEA.D3.day3;

import java.io.*;
import java.util.*;

/**
 * 길이 N 의 순열이란 1~N 까지의 자연수를 적당한 순서로 섞어서 만든 수열
 * (3,4,1,2) 는 길이 4의 순열
 */
public class SW_9940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ArrayList<Integer> list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine()); // 4
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(str[i]));
            }
            Collections.sort(list);
            boolean flag = false;
            for (int i = 1; i <= N; i++) {
                if (i != list.get(i - 1)) {
                    flag = true;
                    break;
                }
            }
            if (flag) System.out.println("#" + tc + " No");
            else System.out.println("#" + tc + " Yes");
        }
    }
}
