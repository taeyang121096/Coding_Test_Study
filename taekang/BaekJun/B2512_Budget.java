package BaekJun;

import java.io.*;
import java.util.*;

/**
 정해진 총액 이하에서 가능한 한 최대의 총 예산
 1. 모든 요청이 배정될 수 있는 경우엔 요청한 금액을 그대로 배정
 2. 모든 요청이 배정될 수 없는 경우엔 특정한 정수 상한액을 계산하여 그 이상인 예상요청에는 모두 상한액을 배정
 상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.
 */

public class B2512_Budget {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 4
        String[] str = br.readLine().trim().split(" ");
        int[] arr = new int[N];
        long max = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str[i]);
            max = Math.max(max, arr[i]);
        }
        int M = Integer.parseInt(br.readLine()); // 485
        // 110 120 140 150
        max++;
        long min = 0;
        while(min < max){
            long mid = (min + max) / 2;
            long sum = 0;
            for(int i = 0; i < N; i++){
                if(arr[i] <= mid){
                    sum += arr[i];
                } else {
                    sum += mid;
                }
            }

            // sum에 저장되겠지?
            if(sum > M){
                max = mid;
            } else {
                min = mid + 1;
            }

        }
        System.out.println(min - 1);
    }
}
