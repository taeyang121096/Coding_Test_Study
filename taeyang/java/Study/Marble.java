import java.util.*;

public class Marble {
    //    . = 0, # = -1, R = 2, B = 3, O = 1
    static int[][] mat;

    //    상하좌우
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int[] go(int row, int col, int dis, int cate) {
        int r_size = mat.length - 1;
        int c_size = mat[0].length - 1;
        mat[row][col] = 0;
        while (true) {
            row += dist[dis][0];
            col += dist[dis][1];
            if (1 > row || 1 > col || row >= r_size || col >= c_size || mat[row][col] == -1 || mat[row][col] > 1 || mat[row][col] == 1) {
                if (mat[row][col] == 1) {
                    return new int[]{row, col};
                } else {
                    row -= dist[dis][0];
                    col -= dist[dis][1];
                }
                break;
            }
        }

        mat[row][col] = cate;
        return new int[]{row, col};
    }
//  1,1 1,5 ->
    static Point[] move(Point[] p, int dis) {

        int rr = p[0].r;
        int rc = p[0].c;
        int cnt = p[0].cnt;
        int br = p[1].r;
        int bc = p[1].c;

        int[] red;
        int[] blue;

        if (dis == 0 && rc == bc) {
            if (rr < br) {
                red = go(rr, rc, dis, 2);
                blue = go(br, bc, dis, 3);
            } else {
                blue = go(br, bc, dis, 3);
                red = go(rr, rc, dis, 2);
            }
        } else if (dis == 1 && rc == bc) {
            if (rr < br) {
                blue = go(br, bc, dis, 3);
                red = go(rr, rc, dis, 2);
            } else {
                red = go(rr, rc, dis, 2);
                blue = go(br, bc, dis, 3);
            }
        } else if (dis == 2 && rr == br) {
            if (rc < bc) {
                red = go(rr, rc, dis, 2);
                blue = go(br, bc, dis, 3);
            } else {
                blue = go(br, bc, dis, 3);
                red = go(rr, rc, dis, 2);
            }
        } else if (dis == 3 && rr == br) {
            if (rc > bc) {
                red = go(rr, rc, dis, 2);
                blue = go(br, bc, dis, 3);
            } else {
                blue = go(br, bc, dis, 3);
                red = go(rr, rc, dis, 2);
            }
        } else {
            red = go(rr, rc, dis, 2);
            blue = go(br, bc, dis, 3);
        }

        Point[] point = new Point[2];
        if(mat[red[0]][red[1]] != 1)
            mat[red[0]][red[1]] = 0;
        if(mat[blue[0]][blue[1]] != 1)
            mat[blue[0]][blue[1]] = 0;
        point[0] = new Point(red[0], red[1], cnt+1);
        point[1] = new Point(blue[0], blue[1], cnt+1);
        return point;
    }


    static void bfs(Point[] p) {
        Deque<Point[]> q = new ArrayDeque<>();
        q.offer(p);
        int count = 0;
        while (!q.isEmpty()) {
            Point[] tmp = q.poll();
            if (mat[tmp[0].r][tmp[0].c] == 1) {
                if (tmp[0].r == tmp[1].r && tmp[0].c == tmp[1].c)
                    count = -1;
                else
                    count = tmp[0].cnt;
                break;
            }
            if(mat[tmp[1].r][tmp[1].c] == 1)
                continue;

            for (int i = 0; i < 4; i++) {
                mat[tmp[0].r][tmp[0].c] = 2;
                mat[tmp[1].r][tmp[1].c] = 3;
                Point[] point = move(tmp,i);
                if(point[0].cnt > 10)
                    continue;
                q.offer(point);
            }
        }
        if(count != -1 && count !=0) {
            answer = count;
            return;
        }

    }


    static int answer = 11;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] str = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                if (str[j] == '.')
                    mat[i][j] = 0;
                else if (str[j] == 'O')
                    mat[i][j] = 1;
                else if (str[j] == 'R')
                    mat[i][j] = 2;
                else if (str[j] == 'B')
                    mat[i][j] = 3;
                else
                    mat[i][j] = -1;
            }
        }

        int rr = 0;
        int rc = 0;
        int br = 0;
        int bc = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    rr = i;
                    rc = j;
                } else if (mat[i][j] == 3) {
                    br = i;
                    bc = j;
                }
            }
        }
        Point[] tmp = new Point[2];
        tmp[0] = new Point(rr, rc, 0);
        tmp[1] = new Point(br, bc, 0);
        bfs(tmp);
        if(answer ==11)
            System.out.println(-1);
        else
            System.out.println(answer);

    }
}
