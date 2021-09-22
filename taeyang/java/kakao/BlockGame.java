public class BlockGame {
    import java.util.*;
    class Solution {
        int[][] Board;
        int size;
//     가로 2 세로 3 & 세로2 가로 3  2500

        boolean checking(int row, int col){
            for(int i =0;i<row;i++){
                if(Board[i][col] != 0)
                    return false;
            }
            return true;
        }

        boolean check(int row,int col,int r,int c){
            int cnt = 0;
            int tmp = 0;
            for(int i = row;i<row+r;i++){
                for(int j = col;j<col+c;j++){
                    if(Board[i][j] == 0){
                        if(!checking(i,j))
                            return false;
                        cnt++;
                        if(cnt > 2) return false;
                    }else{
                        if( tmp != 0 && Board[i][j] != tmp )
                            return false;
                        tmp = Board[i][j];
                    }
                }
            }
            for(int i = row;i<row+r;i++){
                for(int j = col;j<col+c;j++)
                    Board[i][j] = 0;
            }
            return true;
        }

        public int solution(int[][] board) {
            int answer = 0;
            Board = board;
            size = board.length;
            int cnt = 0;
            do{
                cnt = 0;
                for(int i = 0;i<size;i++){
                    for(int j = 0;j<size;j++){
                        if(i+2 <=size && j+3 <= size && check(i,j,2,3)){
                            cnt++;
                        }
                        else if(i+3 <= size && j+2 <= size && check(i,j,3,2)){
                            cnt++;
                        }
                    }
                }
                answer += cnt;
            }while(cnt != 0);


            return answer;
        }
    }
}
