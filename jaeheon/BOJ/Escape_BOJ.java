package BOJ;

import java.util.*;
import java.io.*;

public class Escape_BOJ {

    static int n, m;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q;
    static Queue<int[]> water;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        q = new LinkedList<>();
        water = new LinkedList<>();

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for (int j = 0; j < m; j++){
                char ch = str.charAt(j);
                arr[i][j] = ch;
                if(ch == 'S'){
                    q.offer(new int[] {i, j});
                } else if(ch == '*'){
                    water.offer(new int[] {i, j});
                }
            }
        }

        if(bfs()){
            System.out.println(answer);
        } else {
            System.out.println("KAKTUS");
        }
    }

    static boolean bfs(){
        while (!q.isEmpty()){
            answer++;
            int waterSize = water.size();
            for(int i = 0; i < waterSize; i++){
                int[] tmp = water.poll();
                for(int j = 0; j < 4; j++){
                    int nr = tmp[0] + dx[j];
                    int nc = tmp[1] + dy[j];

                    if(nr < 0 || nc < 0 || nr >= n || nc >= m || arr[nr][nc] == 'X' || arr[nr][nc] == '*' || arr[nr][nc] == 'D'){
                        continue;
                    }
                    water.offer(new int[] {nr, nc});
                    arr[nr][nc] = '*';
                }
            }

            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                int[] tmp = q.poll();
                for(int j = 0; j < 4; j++){
                    int nr = tmp[0] + dx[j];
                    int nc = tmp[1] + dy[j];

                    if(nr < 0 || nc < 0 || nr >= n || nc >= m || arr[nr][nc] == 'X' || arr[nr][nc] == '*' || arr[nr][nc] == 'S'){
                        continue;
                    }
                    if(arr[nr][nc] == 'D'){
                        return true;
                    }
                    q.offer(new int[] {nr, nc});
                    arr[nr][nc] = 'S';
                }
            }
        }
        return false;
    }
}