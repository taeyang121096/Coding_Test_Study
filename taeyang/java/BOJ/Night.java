package basic;
import java.util.*;
import java.io.*;
public class Night {

    static int[][] mat;
    static boolean[][]check;
    static int[][]dir= {{-1,-2},{-2,-1},{-1,2},{-2,1},{1,-2},{2,-1},{2,1},{1,2}};
    static void bfs(int row,int col){
        Queue<int[]>q = new ArrayDeque<>();
        q.offer(new int[]{row,col});
        check[row][col] = true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            for(int[]d : dir){
                int nr = r+d[0];
                int nc = c+d[1];
                if(nr>=0&&nr<mat.length&&nc>=0&&nc<mat.length&&!check[nr][nc]){
                    check[nr][nc] = true;
                    mat[nr][nc] += mat[r][c]+1;
                    q.offer(new int[]{nr,nc});
                }

            }
        }
    }
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            mat = new int[n][n];
            check = new boolean[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            bfs(r,c);
            st = new StringTokenizer(br.readLine()," ");
            int nr = Integer.parseInt(st.nextToken());
            int nc = Integer.parseInt(st.nextToken());
            System.out.println(mat[nr][nc]);
        }
    }
}
