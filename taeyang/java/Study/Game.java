import java.util.*;
public class Game {

    static int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
    static class Board{
        int[][] mat;
        int cnt;
        public Board(int[][] mat, int cnt){
            this.mat = mat;
            this.cnt = cnt;
        }
    }
    static int ans = 0;
    static int n;
    static void bfs(Board b){
        Deque<Board> q = new ArrayDeque<>();
        q.offer(b);

        while(!q.isEmpty()){
            Board tmp = q.poll();
            if(tmp.cnt > 5)
                continue;

            int max = 0;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    max = Math.max(max,tmp.mat[i][j]);
                }
            }
            ans = Math.max(ans, max);
            for(int i = 0;i<4;i++){
                check = new boolean[n][n];
                int[][] arr = new int[n][n];
                for(int r = 0;r<n;r++)
                    arr[r] = tmp.mat[r].clone();
                Board bt = move(arr,i,tmp.cnt);
                q.offer(bt);
            }
        }

    }
    static void go(int[][]mat,int r,int c, int dis){
        int val = mat[r][c];

        mat[r][c] = 0;

        while(true){
            r += dist[dis][0];
            c += dist[dis][1];

            if(r < 0 || r >=n || c<0 || c>=n ){
                r -= dist[dis][0];
                c -= dist[dis][1];
                break;
            }

            if(mat[r][c] != 0 ){
                if(mat[r][c] == val && check[r][c] != true){
                    check[r][c] = true;
                    mat[r][c] += val;
                    return;
                }
                r-=dist[dis][0];
                c-=dist[dis][1];
                break;
            }
        }
        mat[r][c] = val;
        return;
    }
    static boolean[][]check;
    static Board move(int[][]mat, int dis,int cnt){

        for(int r=0;r<n;r++){
            for(int c = 0;c<n;c++){
                if(mat[r][c] == 0)
                    continue;
                go(mat,r,c,dis);
            }
        }

        return new Board(mat,cnt+1);

    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        int [][]mat = new int[n][n];
        for(int i = 0;i<n;i++){
            String[] str = sc.nextLine().split(" ");
            for(int j = 0;j<n;j++){
                mat[i][j] = Integer.parseInt(str[j]);
            }
        }
        int[][] tmp = new int[n][n];
        for(int i = 0;i<n;i++)
            tmp[i] = mat[i].clone();
        bfs(new Board(tmp,0));
        System.out.println(ans);

    }
}
