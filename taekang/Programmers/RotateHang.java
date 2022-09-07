package Programmers;

public class RotateHang {
    public static int[][] map;

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4}, {3,3,6,6},{5,1,6,3} };
        map = new int[rows][columns];
        int[] answer = new int[queries.length]; //
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = (i * columns + j + 1);
            }
        }

        for (int i = 0; i < queries.length; i++) {

            int nowX = queries[i][0] - 1; // x1
            int nowY = queries[i][1] - 1; // y1

            int endX = queries[i][2] - 1; // x2 = 5
            int endY = queries[i][3] - 1; // y2 = 4

            int min = Integer.MAX_VALUE;

            int x = 0;

            int tmp = map[nowX][nowY]; // x1 y1+2
            while (true) {
                if (nowY + dir[x][1] > endY || nowX + dir[x][0] > endX ||
                        nowY + dir[x][1] < queries[i][1] - 1 || nowX + dir[x][0] < queries[i][0] - 1) { //
                    x++;
                }

                if (x == 4) {
                    break;
                }

                int dx = dir[x][0]; // 0
                int dy = dir[x][1]; // 1

                nowX += dx; // x1+0
                nowY += dy; // y1+2

                int tmp2 = tmp; // map[x1][y+1]
                tmp = map[nowX][nowY]; // map[x1][y1+2]
                map[nowX][nowY] = tmp2; // map[2][y1+2] = [2][3]

                min = Math.min(min, tmp);
                min = Math.min(min, tmp2);
            }

            answer[i] = min;
        }
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
    }
}
