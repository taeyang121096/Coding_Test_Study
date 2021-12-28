import java.util.*;
public class Crain_Pro {

    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<Integer>();
            int depth = board[0].length;
            for(int i : moves){
                int val = 0;
                for(int j=0;j<depth;j++){
                    if(board[j][i-1] !=0){
                        val = board[j][i-1];
                        board[j][i-1] = 0;
                        break;
                    }
                }
                if(val == 0)
                    continue;
                if(stack.isEmpty())
                    stack.push(val);
                else{
                    if(stack.peek() == val){
                        stack.pop();
                        answer += 2;
                    }else{
                        stack.push(val);
                    }
                }

            }
            return answer;
        }
    }
}
