//import java.util.*;
//class Solution {
//    static int round = 0;
//    static int cnt = 0;
//
//    public int[] solution(String s) {
//
//        while(!s.equals("1")){
//            char[] charArr = s.toCharArray(); //
//            cnt += cntZero(charArr, '0'); // 6
//            s = s.replace("0", ""); // 111111
//            int lgx = s.length();
//            s = Integer.toBinaryString(lgx);
//            round++;
//        }
//        int[] answer = {round, cnt};
//        return answer;
//    }
//
//    public int cntZero(char[] arr, char c){
//        int n = 0;
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i] == c){
//                n++;
//            }
//        }
//        return n;
//    }
//}