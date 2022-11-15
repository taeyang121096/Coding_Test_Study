package SWEA.D3.day3;

import java.io.*;
import java.util.*;

public class SW_10965 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int i = 1;
            int tmp = 1;
            while(true){
                double sqrt = Math.sqrt(N * i);
                if (sqrt == (int) sqrt) {
                    tmp = i;
                    break;
                }
                i++;
            }
            System.out.println("#" + tc + " " + tmp);
        }
    }
}
