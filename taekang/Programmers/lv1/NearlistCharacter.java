//import java.util.*;
//
//class Solution {
//    public int[] solution(String s) { // banana
//        int[] answer = new int[s.length()];
//        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
//        for(int i = 0; i < s.length(); i++){
//            if(!map.containsKey(s.charAt(i))){
//                map.put(s.charAt(i), new ArrayList<>(List.of(i)));
//                answer[i] = -1;
//            } else {
//                ArrayList<Integer> list = map.get(s.charAt(i));
//                int last_idx = list.get(list.size()-1);
//                answer[i] = i-last_idx;
//                list.add(i);
//                map.put(s.charAt(i), list);
//            }
//        }
//        return answer;
//    }
//}