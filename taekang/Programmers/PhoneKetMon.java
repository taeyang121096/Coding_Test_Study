//import java.util.*;
//class Solution {
//    public int solution(int[] nums) {
//        int answer = 0;
//        // N 마리 포켓 몬 중, N/2 마리
//        // 같은 종류의 포켓몬은 같은 번호를 가짐
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < nums.length; i++){
//            if(!map.containsKey(nums[i])){
//                map.put(nums[i] , 1);
//            } else {
//                map.put(nums[i], map.get(nums[i]) + 1);
//            }
//        }
//        int m = nums.length / 2;
//
//        if(m<map.size()){
//            answer = m;
//        } else if (m == map.size()){
//            answer = m;
//        } else {
//            answer = map.size();
//        }
//
//        return answer;
//    }
//}