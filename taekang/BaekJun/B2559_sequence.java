package BaekJun;

import java.io.*;
import java.util.*;

public class B2559_sequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 10 2
        int N = Integer.parseInt(st.nextToken()); // 10
        int K = Integer.parseInt(st.nextToken()); // 5
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 3 ... -3
        }
        int[] tmp = new int[N-K+1]; // 10 - 5
        for(int i = 0; i <= N-K; i++){ // 0 1 2 3 4
            int sum = 0;
            for(int j = i; j < i+K; j++){ // 3 4 5 6 7
                sum += arr[j];
            }
            tmp[i] = sum;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < tmp.length; i++){
            max = Math.max(max, tmp[i]);
        }
        System.out.println(max);
    }
}
