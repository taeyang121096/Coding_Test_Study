//알아볼 수 없는 번호는 0
//최고순위와 최저순위를 배열에 담아 리턴
//6 ->1등   5->2등   4->3등   3->4등   2-> 5등   1, 0 -> 6등
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int best = 1;
        int worst = 1;
        
        for(int i = 0; i<win_nums.length; i++){
            hm.put(win_nums[i], 1);
        }
        for(int i = 0; i<lottos.length; i++){
            if(worst>5){
                break;
            }
            if(lottos[i]>0){
                if(!hm.containsKey(lottos[i])){
                    best++;
                    worst++;
                }
            }
            else{
                worst++;
            }
        }
        int[] answer = {best, worst};
        return answer;
    }
}