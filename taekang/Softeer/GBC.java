package Softeer;

/**
 * 첫번쨰 구간은 50 제한 50m/s
 * 두번째 구간은 40 제한 40m/s
 * 세번째 구간은 10 제한 30m/s
 */

import java.util.*;
import java.io.*;

public class GBC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 3
        int M = Integer.parseInt(st.nextToken()); // 3
        int max = Integer.MIN_VALUE;

        int[][] arr = new int[N][2]; // {50,50} {40,40} {10,30}
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
//            System.out.println(arr[i][0] + " " + arr[i][1]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int idx = 0;
            while (a != 0) {
                if(arr[idx][0] <= 0){
                    idx++;
                    continue;
                }

                if(arr[idx][0] <= a){
                    a -= arr[idx][0];
                    arr[idx][0] = 0;
                    if(arr[idx][1] <= b){
                        max = Math.max(max, b-arr[idx][1]);
                    }
                    idx++;
                } else {
                    arr[idx][0] -= a;
                    if(arr[idx][1] <= b){
                        max = Math.max(max, b-arr[idx][1]);
                    }
                    a = 0;
                }
            }
        }

        if (max == Integer.MIN_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(max);
        }

//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            while(a != 0){
//
//            }
//        }
    }
}
