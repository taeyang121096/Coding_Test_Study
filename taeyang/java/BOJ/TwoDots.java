package basic;
import java.util.*;
import java.io.*;
public class TwoDots {
    static int n;
    static int m;
//    상 하 좌 우
    static int[][]dir = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,-1},{-1,1},{1,1}};
    static char[][] mat;
    static boolean[][] check;
    static int row;
    static int col;
    static void dfs(int r,int c,int count){
        check[r][c] = true;
        for(int[] d : dir){
            int nr = r+d[0];
            int nc = c+d[1];
            if( nr>=0 && nr<n &&nc >= 0&&nc<m&&mat[nr][nc] == mat[r][c]) {
                if(!check[nr][nc]) {
                    check[nr][nc] = true;
                    dfs(nr, nc, count + 1);
                }else{
                    if(count >= 4 && nr == row && nc == col){
                        System.out.print("Yes");
                        System.exit(0);
                    }
                }
            }



        }

    }
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mat = new char[n][m];
        check = new boolean[n][m];
        for(int i = 0;i<n;i++){
            int index = 0;
            for(char c : br.readLine().toCharArray()){
                mat[i][index++] = c;
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!check[i][j]) {
                    row = i;
                    col = j;
                    dfs(i, j, 1);
                }
            }
        }
        System.out.println("No");
    }
}
