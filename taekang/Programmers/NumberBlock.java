//class Solution {
//    public int[] solution(long begin, long end) {
//        int b = (int)begin;
//        int e = (int)end;
//        int[] answer = new int[e-b+1];
//        for(int i = b; i <= e; i++){
//            answer[i-b] = divisor(i);
//        }
//
//        return answer;
//    }
//
//    public int divisor(int n){
//        if(n == 1){
//            return 0;
//        }
//
//        for(int i = 2; i <= Math.sqrt(n); i++){
//            if(n % i == 0 && n/i <= 10000000){
//                return n/i;
//            }
//        }
//
//        return 1;
//    }
//}