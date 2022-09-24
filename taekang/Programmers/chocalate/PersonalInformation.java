///**
// 1~n 번 개인정보, 개인정보 보관 유효기간이 정해져있음..
// 유효기간 전까지만 보관가능, 지났다면 반드시 파기
// **/
//import java.util.*;
//class Solution {
//    public Map<String, Integer> map = new HashMap<>();
//    public List<Integer> list = new ArrayList<>();
//    public int[] solution(String today, String[] terms, String[] privacies) {
//        for(int i = 0; i < terms.length; i++){
//            String[] str = terms[i].split(" ");
//            if(!map.containsKey(str[0])){
//                map.put(str[0], Integer.parseInt(str[1]));
//            }
//        }
//
//        // 일수를 모두 구해서 -> yyyy mm dd, 일수로 무조건
//        String[] s = today.split("\\.");
//        int today_days = (Integer.parseInt(s[0])-2000)*28*12 + Integer.parseInt(s[1])*28 + Integer.parseInt(s[2]);
//        for(int i = 0; i < privacies.length; i++){
//            String[] str = privacies[i].split(" ");
//            String[] tmp = str[0].split("\\.");
//            int now_days =
//                    (Integer.parseInt(tmp[0])-2000)*28*12 + Integer.parseInt(tmp[1])*28 + Integer.parseInt(tmp[2]) + map.get(str[1])*28;
//
//            if(today_days >= now_days){
//                list.add(i+1);
//            }
//        }
//
//        int[] answer = new int[list.size()];
//        for(int i = 0; i < list.size(); i++){
//            answer[i] = list.get(i);
//        }
//        return answer;
//    }
//}