import java.io.*;
import java.util.StringTokenizer;

public class Ladder_BOJ {

    // n이 세로선 -> row
//    m이 가로선
//    h => col
//    정답이 3 초과이면 -1 , 불가능 -1
//    n = 2 m = 1 h =3
//    1 0 0 0 0
//    0 0 1 0 0
//    0 1 0 0 0
//    0 0 0 0 0
//    1 0 0 1 0
//    0 0 0 0 0
//    1. 값을 0 에서 1로 변환
//    2. dfs 1 ~ 3 까지 해서 값 출력
//
//    1 0
//    0 0
//    0 0
    static int ans = 4;
    static int num;
    static int col;
    static int row;
    static int[][] mat;

    static boolean check() {
        for (int i = 0; i < col; i++) {
            num = -1;
            go(0, i,false);
            if (num != i)
                return false;
        }
        return true;
    }

    static void go(int r, int c,boolean flag) {
        if (num != -1)
            return;
        if (r == row) {
            num = c;
            return;
        }
        if (mat[r][c] == 0||flag == true)
            go(r + 1, c,false);
        if (c - 1 >= 0 && mat[r][c] == 1 && mat[r][c - 1] == 1&&flag ==false) {
            go(r, c - 1,true);
        }
        if (c + 1 < col && mat[r][c] == 1 && mat[r][c + 1] == 1&&flag ==false) {
            go(r, c + 1,true);
        }
    }

    static void dfs(int level,int i){
        if(ans != 4)
            return;
        if(level == i){
            if(check()){
                ans = level;
            }
            return;
        }
        for(int r = 0;r<row;r++){
            for(int c = 0;c<col;c++){
                if(mat[r][c] == 1)
                    continue;
                if(c-1>=0 && mat[r][c-1] == 0){
                    mat[r][c] = 1;
                    mat[r][c-1] = 1;
                    dfs(level+1,i);
                    mat[r][c] = 0;
                    mat[r][c-1] = 0;
                }
                if(c+1<col && mat[r][c+1] == 0){
                    mat[r][c] = 1;
                    mat[r][c+1] = 1;
                    dfs(level+1,i);
                    mat[r][c] = 0;
                    mat[r][c+1] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        col = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        mat = new int[row][col];
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            mat[r][c] = 1;
            mat[r][c + 1] = 1;
        }
        if (check()) {
            ans = 0;
        } else {
            for (int i = 1; i <= 3; i++) {
                if (ans != 4)
                    break;
                dfs(0, 3);
            }
        }

        if (ans == 4)
            ans = -1;
        System.out.println(ans);
    }

}
