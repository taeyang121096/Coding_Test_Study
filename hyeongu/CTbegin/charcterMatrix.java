class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int x = board[0] / 2;
        int y = board[1] / 2;
        int move = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for(String str : keyinput){
            switch(str){
                case "left":
                    move = 0;
                    break;
                case "right":
                    move = 1;
                    break;
                case "up":
                    move = 2;
                    break;
                case "down":
                    move = 3;
                    break;
            }
            int nx = answer[0] + dx[move];
            int ny = answer[1] + dy[move];
            
            if(nx <= x && nx >= -x && ny <= y && ny >= -y){
                answer[0] = nx;
                answer[1] = ny;
            }
        }
        return answer;
    }
}