package BOJ;

import java.io.*;
import java.util.*;

public class puyopuyo {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] arr;
    static boolean flag = true;


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        arr = new char[12][];

        for(int i = 0; i < 12; i++){
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }

        while(flag){
            flag = false;
            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){
                    if(arr[i][j] != '.'){
                        bfs(i, j);
                    }
                }
            }
            if(flag){
                answer++;
                down();
            }
        }
        System.out.println(answer);
    }

    static void down(){
        for(int i = 0; i < 6; i++){
            Stack<Character>st = new Stack<>();
            for(int j = 11; j >= 0; j--){
                if(arr[j][i] != '.'){
                    st.push(arr[j][i]);
                }
            }
            for(int j = 0; j < 12 - st.size(); j++){
                arr[j][i] = '.';
            }
            for(int j = 12 - st.size(); j < 12; j++){
                arr[j][i] = st.pop();
            }
        }
    }
    static void bfs(int r, int c){
        boolean[][] check = new boolean[12][6];
        Queue<int[]>q = new LinkedList<>();
        Stack<int[]>st = new Stack<>();

        q.offer(new int[] {r, c});
        st.push(new int[] {r, c});
        check[r][c] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i = 0; i < 4; i++){
                int nr = now[0] + dx[i];
                int nc = now[1] + dy[i];

                if(nr >= 12 || nc >= 6 || nr < 0 || nc < 0 || check[nr][nc]) continue;
                check[nr][nc] = true;

                if(arr[nr][nc] == arr[r][c]){
                    cnt++;
                    q.offer(new int[] {nr, nc});
                    st.push(new int[] {nr, nc});
                }
            }
        }
        if(cnt>=4){
            flag = true;
            while(!st.isEmpty()){
                int[] tmp = st.pop();
                arr[tmp[0]][tmp[1]] = '.';
            }
        }
    }
}