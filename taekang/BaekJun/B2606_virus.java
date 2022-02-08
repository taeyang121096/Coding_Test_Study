package BaekJun;

import java.io.*;
import java.util.*;

public class B2606_virus {

    static int[][] map;
    static boolean[] isUsed;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 7
        int num = Integer.parseInt(br.readLine());

        map = new int[101][101];
        isUsed = new boolean[101];

        // 6
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            String[] s = input.split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            map[x][y] = map[y][x] = 1;
        }

        DFS(num, 1);
        System.out.println(list.size() - 1);
    }

    public static void DFS(int num, int i) {
        isUsed[i] = true;
        list.add(i);
        for (int j = 1; j < num + 1; j++) {
            if (map[i][j] == 1 && isUsed[j] == false) {
                DFS(num, j);
            }
        }
    }
}
