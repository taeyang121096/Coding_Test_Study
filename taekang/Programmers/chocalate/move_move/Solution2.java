///**
// 물품을 구매한 고객은 하루에 최대 1장의 할인 쿠폰
// 고객 한 명당 최대 k 장 까지 할인 쿠폰
// **/
//import java.util.*;
//
//class Solution {
//    public int solution(String[] id_list, int k) {
//        int answer = 0;
//
//        HashMap<String, Integer> map = new HashMap<>();
//        for(int i = 0; i < id_list.length; i++){
//            HashSet<String> set = new HashSet<>();
//            String[] str = id_list[i].split(" ");
//
//            for(int j = 0; j < str.length; j++){
//                set.add(str[j]);
//            }
//
//            for(String s : set){
//                if(!map.containsKey(s)){
//                    map.put(s, 1);
//                } else {
//                    if(map.get(s) == k) continue;
//                    else map.put(s, map.get(s)+ 1);
//                }
//            }
//        }
//
//        for(String kmp : map.keySet()){
//            answer += map.get(kmp);
//        }
//
//        return answer;
//    }
//}