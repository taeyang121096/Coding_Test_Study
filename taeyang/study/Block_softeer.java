import java.util.*;
import java.io.*;

public class Block_softeer {


    static int n;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int cnt = 0;

    static void change(int r, int c) {
        cnt++;
        mat[r][c] = 0;
        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && mat[nr][nc] == 1) {
                change(nr, nc);
            }
        }
    }

    static int[][] mat;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            int idx = 0;
            for (char c : br.readLine().toCharArray()) {
                mat[i][idx++] = Character.getNumericValue(c);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    cnt = 0;
                    change(i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int i : list)
            System.out.println(i);

    }
}

