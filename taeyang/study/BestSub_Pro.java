public class BestSub_Pro {
    class Solution {
        //     10 % 4 -> 2
//      = 2
//      0 1 2
//      2 2 3 3
//     10 % 6 - > 4
//     0 1 3 4 5 6
//     1 1 2 2 2 2
        public int[] solution(int n, int s) {
            int[] answer;
            if(n>s){
                answer = new int[1];
                answer[0] = -1;
                return answer;
            }
            answer = new int[n];
            if(n%s == 0){
                for(int i  = 0;i<n;i++)
                    answer[i] = n/s;
            }else{
                int val = s%n;
                for(int i = 1;i<=val;i++){
                    answer[n-i] = s/n+1;
                }
                for(int i = 0;i<n-val;i++)
                    answer[i] = s/n;
            }


            return answer;
        }
    }
}
