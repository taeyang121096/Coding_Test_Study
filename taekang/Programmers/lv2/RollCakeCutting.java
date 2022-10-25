//
///**
// 잘린 조각들의 크기와 올려진 토핑의 개수에 상관없이 각 조각에 동일한 가짓수의 토핑이 올라가면 공평하게 롤케이크가 나누어진 것
// **/
//import java.util.*;
//class Solution {
//    public Map<Integer, Integer> chulsu = new HashMap<>();
//    public Map<Integer, Integer> sister = new HashMap<>();
//
//    public int solution(int[] topping) {
//        int answer = 0;
//        chulsu.put(topping[0], 1);
//
//        for(int i = 1; i < topping.length; i++){
//            if(!sister.containsKey(topping[i])){
//                sister.put(topping[i], 1);
//            } else {
//                sister.put(topping[i], sister.get(topping[i])+1);
//            }
//        }
//
//        // System.out.println(chulsu.size() + " " + sister.size());
//        if(chulsu.size() == sister.size()) answer++;
//
//        for(int i = 1; i < topping.length; i++){
//            // 먼저 chulsu에 넣고, 해당 토핑을 sister에서 찾아서 삭제함. 0이되면 아예 없애는거로
//            if(!chulsu.containsKey(topping[i])){
//                chulsu.put(topping[i], 1);
//            } else {
//                chulsu.put(topping[i], chulsu.get(topping[i])+1);
//            }
//
//            if(sister.get(topping[i]) == 1){
//                sister.remove(topping[i]);
//            } else if (sister.get(topping[i]) > 1){
//                sister.put(topping[i], sister.get(topping[i])-1);
//            }
//
//            if(chulsu.size() == sister.size()) answer++;
//        }
//
//        return answer;
//    }
//}