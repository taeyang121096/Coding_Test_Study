//class Solution {
//    boolean solution(String s) {
//        boolean answer = true;
//
//        // 괄호가 바르게 짝지어졌다? '(' 로 열렸으면 반드시 ')' 문자로 닫혀야 한다.
//        int cnt = 0;
//        if(s.charAt(0) == ')'){
//            return false;
//        } else {
//            for(int i = 0; i < s.length(); i++){
//                if(cnt <= 0){
//                    if(s.charAt(i) == ')'){
//                        return false;
//                    } else {
//                        cnt++;
//                    }
//                } else {
//                    if(s.charAt(i) == '('){
//                        cnt++;
//                    } else {
//                        cnt--;
//                    }
//                }
//            }
//        }
//
//        if(cnt == 0){
//            answer =  true;
//        } else {
//            answer =  false;
//        }
//
//        return answer;
//    }
//}