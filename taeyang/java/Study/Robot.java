import java.util.*;
import java.io.*;

public class Robot {
    //    북 : 0 동 : 1 남 : 2 서 :3
//    북 -> 서, 서 -> 남, 남 ->동, 동 ->북
//    0 -> 3, 3 -> 2, 2 -> 1, 1-> 0
    static int[][] dist = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Point {
        int row;
        int col;
        int dir;

        public Point(int row, int col, int dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }

    static int ans = 0;

    static void clean(Point cur) {
        boolean flag = false;

        if (check[cur.row][cur.col] != true) {
            check[cur.row][cur.col] = true;
            ans++;
        }

        for(int i =0;i<4;i++) {
            int nr = cur.row + dist[(cur.dir + 3) % 4][0];
            int nc = cur.col + dist[(cur.dir + 3) % 4][1];
            if(check[nr][nc] != true){
                clean(new Point(nr,nc,(cur.dir + 3) % 4));
                flag = true;
                break;
            }
            cur.dir = (cur.dir + 3) % 4;
        }

//        북 r+1 남 r-1 동 c-1 서 c+1
        if(flag == false){
            int nr = cur.row-dist[cur.dir][0];
            int nc = cur.col-dist[cur.dir][1];
            if(mat[nr][nc] == 0){
                clean(new Point(nr,nc,cur.dir));
            }
        }


    }

    static int[][] mat;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        mat = new int[n][m];
        check = new boolean[n][m];
        st = new StringTokenizer(br.readLine(), " ");
        Point cur = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1)
                    check[i][j] = true;
            }
        }


        clean(cur);
        System.out.println(ans);


    }
}
