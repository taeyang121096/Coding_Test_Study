import java.util.*;
import java.io.*;

public class Iceberg_BOJ {

    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean flag = false;
        while(true){
            if(check()){
                flag = true;
                break;
            }
            answer++;
            melt();
            int berg = 0;
            visit = new boolean[n][m];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] <= 0 || visit[i][j]){
                        continue;
                    }
                    berg++;
                    dfs(i, j);
                }
            }

            if(berg >= 2){
                break;
            }
        }

        if(flag){
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }

    static void dfs(int r, int c) {
        visit[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];
            if(nr < 0 || nc < 0 || nr >= n || nc >= m || visit[nr][nc]){
                continue;
            }
            if(arr[nr][nc] > 0){
                dfs(nr, nc);
            }
        }
    }

    static void melt() {
        int[][] tmp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int sea = 0;
                if(arr[i][j] > 0){
                    sea = seaCnt(i, j, sea);
                    if(arr[i][j] < sea){
                        tmp[i][j] = 0;
                    } else {
                        tmp[i][j] = arr[i][j] - sea;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = tmp[i][j];
            }
        }
    }

    private static int seaCnt(int r, int c, int sea) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (nr < 0 || nc < 0 || nr >= n || nc >= m || arr[nr][nc] != 0) {
                continue;
            }
            sea++;
        }
        return sea;
    }


    static boolean check() {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] > 0){
                    return false;
                }
            }
        }
        return true;
    }
}