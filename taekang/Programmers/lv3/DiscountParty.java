///**
// 일정 금액 지불 -> 10일 회원 자격 부여
// 매일 한가지 제품 할인 행사 / 하루에 하나씩만 구매 가능
// 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입
//
// 바나나 3개, 사과 2개, 쌀 2개, 돼지고기 2개, 냄비 1개이며
// 치킨, 사과, 사과, 바나나, 쌀, 사과, 돼지고기, 바나나, 돼지고기, 쌀, 냄비, 바나나, 사과, 바나나 // 15일 연속
// **/
//import java.util.*;
//class Solution {
//    public int solution(String[] want, int[] number, String[] discount) {
//        HashMap<String, Integer> map = new HashMap<>();
//
//        int answer = 0;
//        // discount - number 개수만큼 진행,
//        int sum = 0;
//        for(int i = 0; i < number.length; i++){
//            sum += number[i];
//        }
//
//        int num = discount.length - sum; // 반뽁해야되는 횟수
//
//        for(int i = 0; i < sum; i++){
//            if(!map.containsKey(discount[i])){
//                map.put(discount[i], 1);
//            } else {
//                map.put(discount[i], map.get(discount[i]) + 1);
//            }
//        }
//
//        if(checkSign(map, want, number)){
//            answer++;
//        }
//
//        // for(String tmp : map.keySet()){
//        //     System.out.println(tmp + " " + map.get(tmp));
//        // }
//        for(int i = 1; i <= num; i++){
//            String minus_stuff = discount[i-1]; // discount[0]
//            String plus_stuff = discount[sum + i - 1]; // discount[10]
//
//            map.put(minus_stuff, map.get(minus_stuff) - 1);
//
//            if(!map.containsKey(plus_stuff)){
//                map.put(plus_stuff, 1);
//            } else {
//                map.put(plus_stuff, map.get(plus_stuff) + 1);
//            }
//
//            if(checkSign(map, want, number)){
//                answer++;
//            }
//        }
//
//        return answer;
//    }
//
//    public boolean checkSign(HashMap<String, Integer> map, String[] want, int[] number){
//        for(int i = 0; i < want.length; i++){
//            if(!map.containsKey(want[i])){ // hashmap 에 key를 포함하지 않는다면,
//                return false;
//            } else { // 포함하는데
//                if(map.get(want[i]) != number[i]){ // want의 number와 다르면
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//}