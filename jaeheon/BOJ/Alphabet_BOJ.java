import java.util.*;
import java.io.*;

public class Alphabet_BOJ {

    static int r;
    static int c;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[] visit;
    static int[][] arr;
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        visit = new boolean[26];

        for(int i = 0; i < r; i++){
            String str = br.readLine();
            for(int j = 0; j < c; j++){
                arr[i][j] = str.charAt(j) - 'A';
            }
        }

        answer = 0;

        dfs(0, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int len) {
        visit[arr[x][y]] = true;
        answer = Math.max(answer, len);

        for(int i = 0; i < 4; i++){
            int nr = x + dx[i];
            int nc = y + dy[i];
            if(nr < 0 || nc < 0 || nr >= r || nc >= c || visit[arr[nr][nc]]){
                continue;
            }
            dfs(nr, nc, len + 1);
            visit[arr[nr][nc]] = false;
        }
    }
}
