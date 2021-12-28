package basic;
import java.util.*;
import java.io.*;

public class Tomato {
//m = col n= row
    static int[][] mat;
    static boolean[][]check;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int m;
    static int n;
    static Queue<int[]> q = new ArrayDeque<>();
    static void make(){
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            check[r][c] = true;
            for(int[] d : dir){
                int nr = r+d[0];
                int nc = c+d[1];
                if(nr>=0 && nr<n && nc >=0 && nc<m && mat[nr][nc] == 0&&check[nr][nc] == false){
                    mat[nr][nc] = mat[r][c] +1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        mat = new int[n][m];
        check = new boolean[n][m];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            int index = 0;
            while(st.hasMoreTokens()) {
                mat[i][index++] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 1)
                    q.offer(new int[]{i,j});
            }
        }
        make();
        boolean flag = false;
        int max = 0;
        for(int i = 0;i<n;i++){
            if(flag)
                break;
            for(int j = 0;j<m;j++) {
                max = Math.max(max,mat[i][j]);
                if (mat[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(max-1);


    }
}
