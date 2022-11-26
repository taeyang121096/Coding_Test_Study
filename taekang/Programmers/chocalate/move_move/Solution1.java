//class Solution {
//    public int solution(int[][] flowers) {
//        int answer = 0;
//        int[] days = new int[366];
//        for(int i = 0; i < flowers.length; i++){
//            int start = flowers[i][0] - 1;
//            int end = flowers[i][1] - 1;
//            for(int j = start; j < end; j++){
//                days[j]++;
//            }
//        }
//
//        for(int i = 0; i < days.length; i++){
//            if(days[i] >= 1){
//                answer++;
//            }
//        }
//        return answer;
//    }
//}