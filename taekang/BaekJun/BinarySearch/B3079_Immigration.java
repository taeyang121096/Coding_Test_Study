package BaekJun.BinarySearch;

import java.io.*;
import java.util.*;

/**
 * 상근이와 친구들은 총 M명, 입국심사대는 총 N개, k번 심사대의 심사관은 Tk만큼 시간이걸림
 */
public class B3079_Immigration {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); // 2, 입국 심사대
        int M = Integer.parseInt(str[1]); // 6, 친구들

        long max = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long left = 0;
        long right = max * M + 1;
        long mid;
        while (left <= right) {
            mid = (left + right) / 2;
            long cnt = 0;
            for(int i = 0; i < N; i++){
                cnt += (mid / arr[i]);
            }

            if(cnt >= M){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
