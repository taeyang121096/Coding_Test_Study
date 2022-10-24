//import java.util.*;
//class Solution {
//    private int getStart(boolean[] check) {
//        for(int i = 0; i < check.length; i++){
//            if (!check[i]) {
//                return i;
//            }
//        }
//        return 0;
//    }
//
//    public int solution(int[] cards) {
//        int answer = 0;
//
//        for (int i = 0; i < cards.length; i++) {
//            boolean[] check = new boolean[cards.length];
//            int start = i; // start = 0
//            //
//            int cnt = 1;
//            check[start] = true; //
//
//            while (true) {
//                if (!check[cards[start] - 1]) { // check[8 - 1] == false
//                    check[cards[start] - 1] = true;
//                    start = cards[start] - 1;
//                    cnt++;
//                } else {
//                    break;
//                }
//            }
//
//            for (int j = 0; j < check.length; j++) {
//                if (!check[j]) {
//                    start = j;
//                    int cnt2 = 0;
//                    while (true) {
//                        if (!check[cards[start] - 1]) { // check[8 - 1] == false
//                            check[cards[start] - 1] = true;
//                            start = cards[start] - 1;
//                            cnt2++;
//                        } else {
//                            break;
//                        }
//                    }
//                    answer = Math.max(answer, cnt * cnt2);
//                }
//            }
//        }
//
//        return answer;
//    }
//}