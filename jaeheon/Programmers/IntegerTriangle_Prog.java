package Programmers;

import java.util.*;
class IntegerTraingle_Prog {

    public int solution(int[][] triangle) {
        int answer = 0;
        int size = triangle.length;        
        int[][] dp = new int[size][size];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1;i<size;i++){
            for(int j = 0;j<=i;j++){
                if(j == 0){
                    dp[i][j] = triangle[i][j]+dp[i-1][j];
                }else if(j == i){
                    dp[i][j] = triangle[i][j]+dp[i-1][j-1];
                }else{
                    dp[i][j] = triangle[i][j]+Math.max(dp[i-1][j-1],dp[i-1][j]);
                }
            }
        }
        
        for(int i = 0;i< dp[size - 1].length; i++){
            if(answer < dp[dp.length - 1][i]){
                answer = dp[dp.length - 1][i];
            }
        }
        // answer = Arrays.stream(dp[size-1]).max().getAsInt();
        
        return answer;
    }
}
