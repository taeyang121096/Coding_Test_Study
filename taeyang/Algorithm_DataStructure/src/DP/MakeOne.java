package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        dp -> 두가지 방법 -> top down, bottom up -> dp 배열로 가능하고 -> 재귀로 가능하다.
//        수학적으로 규칙을 찾는거에요 -> 그것보다는 memorize -> 기존값을 미리 알아두고 다음 계산에 그 값을 사용한다.
        int x = Integer.parseInt(st.nextToken());
/**
 *   1 . 1 : 0 ->
 *   2 . 2 : 1 -> 2 , -1
 *   3 . 3 : 1 -> 3
 *   4.  4 : 2 -> -1 + 3, 2 + 2
 *   5.  5 : 3 -> -1 + 4,
 *   6.  6 : 2  -> -1+ 5 , 2 +4, 3+3
 *   7.  7 : 3  -> -1 + 6, 3 + 4 ,2 + 5
 *   8.  8 : 3  ->  1+ 4, -1 + 7
 *   9.  9 : 2  -> -1 + 8 2+7 333
 *   10. 10     -> -1 9
 *    -> 3으로 나눠보고
 *    -> 2으로 나눠보고
 *    -> -1로 빼보고
  */
//        if(x == 1)
//            return 0;
//        if(x <3)
//            return 1;
        int[] dp = new int[x+1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4;i<=x;i++){
            int min = Integer.MAX_VALUE;
            min = Math.min(min,dp[i-1]+1);
            if(i%2 ==0)
                min = Math.min(min,dp[i/2]+1);
            if(i%3 == 0)
                min = Math.min(min,dp[i/3]+1);
            dp[i] = min;
        }
        for(int i : dp)
            System.out.println(i);


    }
}
