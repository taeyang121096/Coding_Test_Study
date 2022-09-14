///**
// 성격 유형이 총 16가지
// N1 C1 M2 T3 A1
// 배치표
// 정방향
// 콘 - 프로도
// 라이언 - 튜브
//
// 역방향
// 무지 - 제이지 M J
// 네오 - 어피치 A N
// **/
//import java.util.*;
//class Solution {
//    public String solution(String[] survey, int[] choices) {
//        Character[] charr
//                = new Character[]{'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
//        int[] scores = new int[]{3,2,1,0,1,2,3};
//        Map<Character, Integer> map = new HashMap<>();
//        // {R T C F J M A}
//        for(int i = 0; i < 8; i++){
//            map.put(charr[i], 0);
//        }
//
//        for(int i = 0; i < survey.length; i++){
//            char a = survey[i].charAt(0);
//            char b = survey[i].charAt(1);
//            int c = choices[i] - 1; // 5
//            // System.out.println(str[0] + " " + str[1]);
//            if(c > 3){ //. 5 6 7
//                map.put(b, map.get(b) + scores[c]);
//            } else if (c < 3){ // 1 2 3
//                map.put(a, map.get(a) + scores[c]);
//            }
//        }
//        // for(char c : map.keySet()){
//        //     System.out.println(c + " " + map.get(c));
//        // }
//        String answer = "";
//        if(map.get('R') < map.get('T')){
//            answer += 'T';
//        } else {
//            answer += 'R';
//        }
//        if(map.get('C') < map.get('F')){
//            answer += 'F';
//        }else {
//            answer += 'C';
//        }
//        if(map.get('J') < map.get('M')){
//            answer += 'M';
//        }else {
//            answer += 'J';
//        }
//        if(map.get('A') < map.get('N')){
//            answer += 'N';
//        } else {
//            answer += 'A';
//        }
//
//        return answer;
//    }
//}