package Programmers;

public class unDestroyedDep {
    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1,2,0,2,3,2}, {2,1,0,3,1,2}, {1,0,1,3,3,1}};

        for(int i = 0; i < skill.length; i++){
            for(int j = 0; j <= (skill[i][3] - skill[i][1]); j++){ // j = 2; j <= 0
                for(int k = 0; k <= (skill[i][4] - skill[i][2]); k++){ // 4
                    if(skill[i][0] == 1){ // skill[0][0] == 1
                        board[skill[i][1] + j][skill[i][2] + k] -= skill[i][5]; // board[0][0] = board[0][0] - skill[0][5]
                    } else if(skill[i][0] == 2){
                        board[skill[i][1] + j][skill[i][2] + k] += skill[i][5];
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] > 0)
                    count++;
            }
        }
        System.out.println(count);
    }
}
