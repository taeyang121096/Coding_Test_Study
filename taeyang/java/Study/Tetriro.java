
import java.util.*;
import java.io.*;

public class Tetriro {
    static int[][] mat;
    static int n;
    static int m;

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static ArrayList<Point[]> list = new ArrayList<>();
    static int count = 0;
    static void make(int row, int col) {
        Point[] tmp;
        if (col + 3 < m) {
            tmp = new Point[4];
            tmp[0] = new Point(row, col);
            tmp[1] = new Point(row, col + 1);
            tmp[2] = new Point(row, col + 2);
            tmp[3] = new Point(row, col + 3);

            list.add(tmp);
        }
        if (row + 3 < n) {
            tmp = new Point[4];
            tmp[0] = new Point(row, col);
            tmp[1] = new Point(row + 1, col);
            tmp[2] = new Point(row + 2, col);
            tmp[3] = new Point(row + 3, col);
            list.add(tmp);
        }
        if (row + 1 < n && col + 1 < m) {
            tmp = new Point[4];
            tmp[0] = new Point(row, col);
            tmp[1] = new Point(row + 1, col);
            tmp[2] = new Point(row + 1, col + 1);
            tmp[3] = new Point(row, col + 1);
            list.add(tmp);
        }
        if (row + 2 < n && col + 1 < m) {
            tmp = new Point[4];
            tmp[0] = new Point(row, col);
            tmp[1] = new Point(row + 1, col);
            tmp[2] = new Point(row + 2, col);
            tmp[3] = new Point(row + 2, col + 1);
            list.add(tmp);
            tmp = new Point[4];
            tmp[0] = new Point(row, col);
            tmp[1] = new Point(row, col + 1);
            tmp[2] = new Point(row + 1, col + 1);
            tmp[3] = new Point(row + 2, col + 1);
            list.add(tmp);
            tmp = new Point[4];
            tmp[0] = new Point(row, col);
            tmp[1] = new Point(row + 1, col);
            tmp[2] = new Point(row + 1, col + 1);
            tmp[3] = new Point(row + 2, col + 1);
            list.add(tmp);
            tmp = new Point[4];
            tmp[0] = new Point(row + 1, col);
            tmp[1] = new Point(row, col + 1);
            tmp[2] = new Point(row + 1, col + 1);
            tmp[3] = new Point(row + 2, col + 1);
            list.add(tmp);
            tmp = new Point[4];
            tmp[0] = new Point(row, col);
            tmp[1] = new Point(row + 1, col);
            tmp[2] = new Point(row + 2, col);
            tmp[3] = new Point(row + 1, col + 1);
            list.add(tmp);
        }
        if (row + 1 < n && col + 2 < m) {
            tmp = new Point[4];
            tmp[0] = new Point(row, col);
            tmp[1] = new Point(row + 1, col);
            tmp[2] = new Point(row, col + 1);
            tmp[3] = new Point(row, col + 2);
            list.add(tmp);
            tmp = new Point[4];
            tmp[0] = new Point(row, col + 2);
            tmp[1] = new Point(row + 1, col);
            tmp[2] = new Point(row + 1, col + 1);
            tmp[3] = new Point(row + 1, col + 2);
            list.add(tmp);
            tmp = new Point[4];
            tmp[0] = new Point(row, col + 1);
            tmp[1] = new Point(row, col + 2);
            tmp[2] = new Point(row + 1, col);
            tmp[3] = new Point(row + 1, col + 1);
            list.add(tmp);
            tmp = new Point[4];
            tmp[0] = new Point(row, col);
            tmp[1] = new Point(row, col + 1);
            tmp[2] = new Point(row, col + 2);
            tmp[3] = new Point(row + 1, col + 1);
            list.add(tmp);
            tmp = new Point[4];
            tmp[0] = new Point(row, col + 1);
            tmp[1] = new Point(row + 1, col);
            tmp[2] = new Point(row + 1, col + 1);
            tmp[3] = new Point(row + 1, col + 2);
            list.add(tmp);
        }
    }
    static int ans = 0;
    static void cal(){
        for(Point[] p : list){
            int sum =0;
            for(int i = 0;i<4;i++){
                Point tmp = p[i];
                sum += mat[tmp.row][tmp.col];
            }
            ans = Math.max(ans,sum);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                make(i, j);
            }
        }
        cal();
        System.out.println(ans);

    }
}
