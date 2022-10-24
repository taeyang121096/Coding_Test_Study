///**
// 문자열에 있는 숫자를 차례대로 더한다..Z가 나오면 바로전에 더했던 숫자를 뺀다.
// **/
//import java.util.*;
//
//class Solution {
//    public int solution(String s) {
//        int sum = 0;
//        String[] str = s.split(" ");
//        Stack<Integer> stack = new Stack();
//        for(int i = 0; i < str.length; i++){
//            if(str[i].equals("Z")){
//                if(stack.isEmpty()){
//                    continue;
//                } else
//                    sum -= stack.pop();
//            } else {
//                stack.push(Integer.parseInt(str[i]));
//                sum += Integer.parseInt(str[i]);
//            }
//        }
//
//        return sum;
//    }
//}