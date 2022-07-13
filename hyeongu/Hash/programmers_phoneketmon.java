// N개 중에서 최대한 겹치지 않고 N/2를 선택
// 1<=N<=10000 항상 짝수
// 종류는 20만
// 선택할 수 있는 종류의 최댓값을 리턴
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i : nums){
            hm.put(i, 1);
        }
        if(hm.size()>N/2){
            return N/2;
        }
        else{
            return hm.size();
        }
    }
}