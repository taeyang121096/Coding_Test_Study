package BaekJun;

import java.io.*;
import java.util.*;

public class B11659_SectionSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); // 5
        int M = Integer.parseInt(str[1]); // 3

        // 5 4 3 2 1
        int[] arr = new int[N];
        String[] str1 = br.readLine().split(" "); //
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str1[i]);
        }

        // 0 5 9 12 14 15
        // tmp[1] += tmp[0] + arr[1] => 0 + 5
        // tmp[2] += tmp[1] + arr[2] => 5 + 4
        // tmp[3] += tmp[2] + arr[3] => 9 + 3
        int[] tmp = new int[N+1];
        for(int i = 1; i <= N; i++){
            tmp[i] += tmp[i - 1] + arr[i-1];
        }
        for(int i = 0; i < tmp.length; i++){
            System.out.println(tmp[i]);
        }
        for(int i = 0; i < M; i++){
            String[] str2 = br.readLine().split(" "); // 1 3
            int a = Integer.parseInt(str2[0]); // 1
            int b = Integer.parseInt(str2[1]); // 3
            System.out.println(tmp[b] - tmp[a-1]);
        }
    }
}
