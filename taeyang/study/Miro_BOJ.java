import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Miro_BOJ {

//    상하 좌우
//    n,m 2 ~ 100
//    dfs, bfs
//
//    1은 이동할 수 있는 칸 0은 이동 못함
    static int[][]mat;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean check[][];
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static void dfs(int r,int c,int cnt){
        if(r == n-1 && c == m-1){
            min = Math.min(min,cnt);
            return;
        }
        check[r][c] = true;
        for(int[] d : dir){
            int nr = r+d[0];
            int nc = c+d[1];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&mat[nr][nc] != 0&&check[nr][nc] == false){
                check[nr][nc] = true;
                dfs(nr,nc,cnt+1);
                check[nr][nc] = false;
            }
        }
    }
    static void bfs(int r, int c,int cost){
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] > o2[2] ? 1:-1;
            }
        });
        q.offer(new int[]{r,c,cost});
        check[0][0] = true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0] == n-1 && tmp[1] == m-1){
                min = Math.min(min,tmp[2]);
                break;
            }
            for(int[]d : dir) {
                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] != 0 && check[nr][nc] == false) {
                    check[nr][nc] = true;
                    q.offer(new int[]{nr, nc, tmp[2] + 1});
                }
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        mat = new int[n][m];

        for(int i = 0;i<n;i++){
            String num = br.readLine();
            for(int j = 0;j<m;j++)
                mat[i][j] = Character.getNumericValue(num.charAt(j));
        }
        check = new boolean[n][m];

//        dfs(0,0,1);
        bfs(0,0,1);
        System.out.println(min);
    }
}
