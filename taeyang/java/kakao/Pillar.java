import java.util.*;

class Solution {

    static boolean[][] matb;
    static boolean[][] matr;

    boolean checkb(int x, int y){
        if(y==0||matb[x][y-1])
            return true;
        if((x>0 && matr[x-1][y]) || matr[x][y])
            return true;
        return false;
    }

    boolean checkr(int x, int y){
        if(matb[x][y-1] || (x < matb.length-1 && matb[x+1][y-1]))
            return true;
        if((x>0 && matr[x-1][y]) && (x<matr.length - 1 && matr[x+1][y]))
            return true;
        return false;
    }

    boolean del(int x, int y){
        for(int i = Math.max(x-1, 0); i<= x+1;i++){
            for(int j = y; j<=y+1;j++){
                if(matb[i][j]&&checkb(i,j) == false)
                    return false;
                if(matr[i][j]&&checkr(i,j) == false)
                    return false;
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {

        matb = new boolean[n+1][n+1];
        matr = new boolean[n+1][n+1];

        int count = 0;
        for(int[] sample : build_frame){
            int x = sample[0], y = sample[1], a = sample[2], b = sample[3];
//             설치
            if(b == 1){
                if(a==0){
                    if(checkb(x,y)){
                        matb[x][y] = true;
                        count++;
                    }

                }else{
                    if(checkr(x,y)){
                        matr[x][y] = true;
                        count++;
                    }

                }
            }
//             삭제
            else{
                if(a==0){
                    matb[x][y] = false;
                    if(del(x,y)==false){
                        matb[x][y] = true;
                    }else{
                        count--;
                    }


                }else{
                    matr[x][y] = false;
                    if(del(x,y)==false){
                        matr[x][y] = true;
                    }else{
                        count--;
                    }

                }
            }

        }

        int[][] answer = new int[count][3];
        count = 0;

        for(int x =0;x<=n;x++){
            for(int y = 0;y<=n;y++){
                if(matb[x][y]){
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count++][2] = 0;
                }
                if(matr[x][y]){
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count++][2] = 1;
                }
            }
        }



        return answer;
    }
}