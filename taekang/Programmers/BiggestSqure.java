//import java.util.*;
//class Solution{
//    static int max = -1;
//    public int solution(int [][]board){
//        int answer = 0;
//        int n = board.length;
//        int m = board[0].length;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (board[i][j] == 1 && i>0 && j>0) {
//                    board[i][j] = Math.min(Math.min(board[i-1][j-1], board[i - 1][j]), board[i][j - 1]) + 1;
//                }
//                answer = Math.max(board[i][j], answer);
//            }
//        }
//
//        return (answer)*(answer);
//    }
//}