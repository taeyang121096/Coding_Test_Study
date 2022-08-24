///**
// 일정한 금액 지불 시 회원 자격 부여, 매일 한가지 제품을 할인하는 행사, 할인하는 애는 하루에 하나씩만
// 정현-제품과 수량이 할인하는 날짜와 10일연속일치할경우 회원가입
// 바나나 3 사과 2 쌀 2 돼지고기 2 냄비 1
//
// 일단 다 map에 집어넣어놓고나서,
// **/
//import java.util.*;
//class Solution {
//    public int solution(String[] want, int[] number, String[] discount) {
//        int num = 0;
//        int answer = 0;
//        for(int i = 0; i < number.length; i++){
//            num += number[i];
//        }
//
//        int idx = -1;
//        for(int i = 0; i <= discount.length - num; i++){ // 14 - 10, i = 0 1 2 3 4
//            Map<String, Integer> map  = new HashMap<>();
//            for(int j = i; j < i+num; j++){ // 4, j < 4+10; 4,5,6,7,8,9,10,11,12,13
//                if(!map.containsKey(discount[j])){
//                    map.put(discount[j], 1);
//                } else {
//                    map.put(discount[j], map.get(discount[j]) + 1);
//                }
//            }
//
//            // for(String key : map.keySet()){
//            //     System.out.println(key + " " + map.get(key));
//            // }
//            // System.out.println("--------");
//
//            boolean flag = true;
//            for(int j = 0; j < want.length; j++){
//                if(map.get(want[j]) != null){ //
//                    if(map.get(want[j]) != number[j]){ //
//                        flag = false;
//                        break;
//                    }
//                } else {
//                    flag=false;
//                    break;
//                }
//            }
//            if(flag){
//                idx = i;
//                answer ++;
//            } else {
//                continue;
//            }
//        }
//
//        return answer;
//    }
//}