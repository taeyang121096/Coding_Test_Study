public class Jump_Pro {
    // index *2 -> index
//  1 칸 점프 당 건전지 량 1
//  dp -> 2 가지 방법 -> 순간이동 걍 가기
//  int[n+1][2] -> 0 인경우는 점프 1 인 경우는 순간이동
//  0 -> 1 2 3 4 5, 1 * 2 ->
//  dp[0][0] = 0, dp[0][1] = 0
//  dp[1][0] = 1, dp[1][1] = 1
//  dp[2][0] =
//  dp [1] = 1, 1
//  dp [2] = 1
//  dp [3] = 2
//  dp [4] = 1
//  dp [5] = 2
//  dp [6]= 2
//  5/2 => 2/2 => 1 -> 1 -> rest -> 2
//  6/2 -> 3, 0 - > 1,1 -> 2
//  5000/2 => 2500,0 -> 1250,0 -> 625,0 -> 312,1 -> 156,0 -> 78,0 -> 39, 0, ->19,1 -> 9,1 -> 4,1 -> 2,0->1,0
    public class Solution {
        public int solution(int n) {
            int ans = 1;
            while(n !=1){
                if(n%2==0){
                    n /=2;
                }else{
                    n/=2;
                    ans++;
                }
            }

            return ans;
        }
    }
}
