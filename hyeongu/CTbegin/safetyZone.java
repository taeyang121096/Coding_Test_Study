class Solution {
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    public int solution(int[][] board) {
        int answer = 0;
        
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board.length; j++){
                if(board[i][j] == 1) continue;
                
                int k;
                for(k = 0; k<8; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    
                    if(nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) continue;
                    if(board[nx][ny] == 1) break;
                }
                if(k == 8) answer++;
            }
        }
        return answer;
    }
}