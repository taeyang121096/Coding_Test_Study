package SWEA.D3;


import java.io.*;
import java.util.*;

public class SW_13732 {
    public static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int j = 0; j < N; j++) {
                // . -> 0 # -> 1
                String[] str = br.readLine().split("");
                for (int k = 0; k < N; k++) {
                    if (str[k].equals(".")) {
                        map[j][k] = 0;
                    } else {
                        map[j][k] = 1;
                    }
                }
            }

        }
    }
}
