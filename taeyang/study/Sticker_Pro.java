public class Sticker_Pro {

    class Solution {
        //     인접 한거는 못 뜯음
//     앞에가 선택되냐 안되냐 가 중요하겠지 -> 인덱스 0 붙어 1붙어
//     n 1 ~ 10만 이하
//     숫자의 합의 최댓값 또는 최솟값 메모이제이션 -> dp다 확신 해도됨 -> dfs 쓰먄 됨
//
        public int solution(int sticker[]) {
            int answer = 0;

            int size = sticker.length;

            int[] dp1 = new int[size];
            int[] dp2 = new int[size];
            if(size ==1)
                return sticker[0];

            dp1[0] = sticker[0];
            dp1[1] = sticker[0];

            for(int i = 2;i<size;i++){
                dp1[i] = Math.max(dp1[i-1],dp1[i-2]+sticker[i]);
            }

            dp2[0] = 0;
            dp2[1] = sticker[1];

            for(int i = 2;i<size;i++){
                dp2[i] = Math.max(dp2[i-1],dp2[i-2]+sticker[i]);
            }

            answer = Math.max(dp1[size-2],dp2[size-1]);

            return answer;
        }
    }
}
