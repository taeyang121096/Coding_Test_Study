//import java.util.*;
//class Solution {
//    public int solution(String[][] clothes) {
//        int answer = 1;
//
//        Map<String, Integer> m = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
//        // 서로 다른 옷의 조합의 수
//        for(int i = 0; i < clothes.length; i++){ // 3
//            // clothes[i][1]; clothes[i][0];
//            if(!m.containsKey(clothes[i][1]))
//                m.put(clothes[i][1], 1);
//            else
//                m.put(clothes[i][1], m.get(clothes[i][1]) + 1);
//        }
//
//        for(String key : m.keySet()){
//            list.add(m.get(key));
//        }
//
//        for(int i = 0; i < list.size(); i++){
//            answer *= (list.get(i)+1);
//        }
//
//        return answer - 1;
//    }
//}