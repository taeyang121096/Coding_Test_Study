package BaekJun;

import java.io.*;
import java.util.*;

public class B1325_efficientHacking {
    static int N;
    static int M;
    static boolean[] check;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        /**
         * N 개의 컴퓨터로 이루어짐, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹
         * 컴퓨터 1. 신뢰하는 2. 신뢰하지않는 A 가 B를 신뢰 하는 경우에는 B 를 해킹하면 A 도 해킹할 수 있다.
         * 한 번에 가장 많은 컴퓨터를 해킹 할 수 있는 컴퓨터의 번호
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().trim().split(" ");
        N = Integer.parseInt(str[0]); // 5
        M = Integer.parseInt(str[1]); // 4
        map = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            map[a][b] = map[b][a] = 1;
        }

        for (int i = 0; i < N; i++) {

        }
    }
}

