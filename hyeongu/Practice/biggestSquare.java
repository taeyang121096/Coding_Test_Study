import java.util.*;

class Solution{
    public int solution(int [][]board){
        int answer = 0;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j]==1&&i>0&&j>0){
                    board[i][j] = Math.min(Math.min(board[i-1][j-1], board[i-1][j]), board[i][j-1])+1;
                }
                answer = Math.max(board[i][j], answer);
            }
        }
        
        return answer*answer;
    }
}