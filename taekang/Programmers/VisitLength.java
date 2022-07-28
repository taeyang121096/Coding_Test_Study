//import java.util.*;
//class Solution {
//    public int solution(String dirs) {
//        int answer = 0;
//        Set<String> s = new HashSet<>();
//
//        int nowX = 0;
//        int nowY = 0;
//        for(int i = 0; i < dirs.length(); i++){
//            int nextX = nowX;
//            int nextY = nowY;
//            String road = "";
//            char c = dirs.charAt(i);
//            if(c == 'U'){
//                nextY++;
//                road += nowX;
//                road += nowY;
//                road += nextX;
//                road += nextY;
//            } else if (c == 'D'){
//                nextY--;
//                road += nextX;
//                road += nextY;
//                road += nowX;
//                road += nowY;
//            } else if (c == 'R'){
//                nextX++;
//                road += nowX;
//                road += nowY;
//                road += nextX;
//                road += nextY;
//            } else {
//                nextX--;
//                road += nextX;
//                road += nextY;
//                road += nowX;
//                road += nowY;
//            }
//
//            if(nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5)
//                continue;
//
//            s.add(road);
//            nowX = nextX;
//            nowY = nextY;
//        }
//        return s.size();
//    }
//}