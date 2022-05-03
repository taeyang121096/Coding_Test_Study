package Programmers;

//가로는 무조건 4칸
//1행부터 땅을 밟으면서 한행씩
//4칸 중 한칸만 밟으면서
//같은 열을 연속해서 밟을 수 없음

//행의 개수 : 10만, 점수 : 100이하

//1  2  3  5
//10 11 12 11
//16 15 13 13

class LandEat_Prog {
 int solution(int[][] land) {
     int answer = 0;
     
     int[][] dp = new int[land.length][land[0].length];
     
     // land 첫번째 행 1,2,3,5
     for(int i = 0; i < land[0].length; i++){
         dp[0][i] = land[0][i];
     }
     
     // for(int i = 0; i < dp[0].length; i++){
     //     System.out.println(dp[0][i]);
     // }
     
     // 두번째 행부터
     for(int i = 1; i < dp.length; i++){
         for(int j = 0; j < dp[0].length; j++){ // 열 개수만큼 반복
             for(int k = 0; k < dp[0].length; k++){ // 다른 열 고르도록
                 if(j == k){ // 같은 열일때
                     continue;
                 }
                 // 이전값 + 현재값 큰 거만 리턴
                 dp[i][j] = Math.max(land[i][j] + dp[i-1][k], dp[i][j]);
             }
         }
     }
     
     // 마지막행에서 최대
     for(int i = 0; i < dp[0].length; i++){
         answer = Math.max(answer, dp[dp.length - 1][i]);
     }

     return answer;
 }
}