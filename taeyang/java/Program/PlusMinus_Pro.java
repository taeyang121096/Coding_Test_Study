public class PlusMinus_Pro {
    static int find(int val){
        int r = val;
        int count = 0;
        for(int i = 1;i<r;i++){
            if(val%i == 0){

                if(i == val/i)
                    count += 1;
                else
                    count += 2;
                r = val/i;
            }
        }
        return count;
    }
    class Solution {



        public int solution(int left, int right) {
            int ans = 0;
            int val = 0;
            if(left == 1){
                ans += -1;
                left +=1;
            }
            for(int i = left;i<=right;i++){
                if(find(i)%2 ==0)
                    ans += i;
                else
                    ans -= i;
            }

            return ans;
        }
    }
}
