package basic;
import java.util.*;
import java.io.*;
public class Island {
    static int count = 0;
    static int mat[][];
    static int row;
    static int col;
//    상하좌우
    static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,-1},{-1,1},{1,1}};
    static void check(int w,int h){
            int r = h;
            int c = w;
            mat[r][c] = 0;
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr>=0 && nr<row && nc>=0 && nc<col&&mat[nr][nc] ==1)
                    check(nc,nr);
            }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0)
                break;
            row = h;
            col = w;
            mat = new int[h][w];

            for(int i = 0;i<h;i++){
                st = new StringTokenizer(br.readLine()," ");
                int index = 0;
                while(st.hasMoreTokens()){
                    mat[i][index++] = Integer.parseInt(st.nextToken());
                }
            }
            count = 0;
            for(int i = 0;i<h;i++){
                for(int j = 0;j<w;j++){
                    if(mat[i][j] == 0)
                        continue;
                    check(j,i);
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
