package BaekJun;

/**
 * 오영식이 이미 가지고 있는 랜선의 개수 K, 필요한 랜선의 개수 N
 */

import java.io.*;
import java.util.*;

public class B1654_CutLan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split(" ");
        int K = Integer.parseInt(str[0]); // 4
        int N = Integer.parseInt(str[1]); // 11
        // 802 743 457 539
        int[] arr = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i])
                max = arr[i];
        }
        max++;
        long min = 0;
        long mid = 0;
        while(min < max){
            mid = (min + max) / 2;
            long count = 0;
            for(int i = 0; i < arr.length; i++){
                count += (arr[i] / mid);
            }

            if(count < N){
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min-1);
    }
}
