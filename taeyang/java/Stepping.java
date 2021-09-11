import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        int lt = 1;
        int rt = distance;
        int pre = 0,cnt=0,mid = 0;

        while(lt<=rt){
            mid = (lt+rt)/2;

            for(int i = 0;i<rocks.length;i++){
                if(rocks[i] - pre < mid){
                    cnt++;
                }else{
                    pre = rocks[i];
                }
            }
            if(distance - pre < mid) cnt++;

            if(cnt > n){
                rt = mid -1;
            }
            else{
                answer = Math.max(answer,mid);
                lt = mid +1;
            }
            cnt = 0;
            pre = 0;
        }


        return answer;
    }
}