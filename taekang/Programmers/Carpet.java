//class Solution {
//    public int[] solution(int brown, int yellow) {
//        int[] answer = new int[2];
//
//        int n = brown+yellow;
//        for(int i = 3; i <= n; i++){
//            int row = i; // 1 2 3 4 5 6...
//            int col = n / row; // 48 24 16 12 8
//
//            if(col<3){
//                continue;
//            }
//
//            if(col >= row){
//                if((col-2)*(row-2) == yellow){
//                    answer[0] = col;
//                    answer[1] = row;
//                    return answer;
//                }
//            }
//        }
//
//        return answer;
//    }
//}