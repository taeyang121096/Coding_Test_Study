//import java.util.*;
//class Solution {
//    public int solution(int[][] board, int[] moves) {
//        // N * N
//        // 격자의 아래 칸부터 차곡 차곡 쌓임..
//        // 가장 위에있는 인형 집어 올림
//        int N = board.length;
//        Deque<Integer> q = new ArrayDeque<>();
//        int answer = 0;
//
//        for(int i = 0; i < moves.length; i++){ // i = 0, 1, 2, 3, 4, 5, 6, 7
//            for(int j = 0; j < N; j++){ //
//                if(board[j][moves[i]-1] != 0){
//                    if(q.isEmpty()){ // 비어있다면 넣어 주고
//                        q.offer(board[j][moves[i]-1]);
//                        board[j][moves[i]-1] = 0;
//                        break;
//                    } else {
//                        if(q.peekLast() == board[j][moves[i]-1]){
//                            q.pollLast();
//                            board[j][moves[i]-1] = 0;
//                            answer+=2;
//                            break;
//                        } else {
//                            q.offer(board[j][moves[i] - 1]);
//                            board[j][moves[i]-1] = 0;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        // System.out.println(q.size());
//        // while(!q.isEmpty()){
//        //     System.out.println(q.poll());
//        // }
//        return answer;
//    }
//}