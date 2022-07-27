//import java.util.*;
//class Solution {
//    public int[] solution(int n, long left, long right) {
//        // 정수 왼 오 1행1열부터
//        // n = 4, left 7 right 14
//        //         |
//        // row = 0 | row = 1 | row = 2 | row = 3
//        // 1 2 3 4 | 2 2 3 4 | 3 3 3 4 | 4 4 4 4
//        // row = 0, left / 4 = 0
//        // left / 4 = row; --> 0, 1, 2, 3
//        // left % 4 = col; --> 0, 1, 2, 3 나머지가 3 이면
//
//        // n = 3
//        // r = 0 | r = 1 | r = 2
//        // 1 2 3 | 2 2 3 | 3 3 3
//
//        // right 14 - left 7 = 7
//        int[] answer = new int[(int)(right-left+1)];
//
//        for(int i = 0; i <= right-left; i++){
//            int row = (int)((left + i) / n); // 1
//            int col = (int)((left + i) % n); // 0, 1, 2, 3
//            if(col+1 <= row){
//                answer[i] = row+1;
//            } else {
//                answer[i] = col+1;
//            }
//        }
//        return answer;
//    }
//}