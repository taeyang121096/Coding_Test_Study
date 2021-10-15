import java.util.*;
import java.io.*;
public class Dice {
    static int[][] map;
    static int[][] dice = new int[4][3];
    static int n;
    static int m;
    static int x;
    static int y;
    static int[][] dist = {{0,1},{0,-1},{-1,0},{1,0}};
//    1 : right 2: left 3 : up 4:down
//    x=row y = col
    static void rotate(int cmd){
        if(cmd ==1){
            int n1 = dice[3][1];
            int n2 = dice[1][0];
            int n3 = dice[1][1];
            int n4 = dice[1][2];
            dice[1][0] = n1;
            dice[1][1] = n2;
            dice[1][2] = n3;
            dice[3][1] = n4;

        }
        else if(cmd ==2){
            int n1 = dice[1][1];
            int n2 = dice[1][2];
            int n3 = dice[3][1];
            int n4 = dice[1][0];
            dice[1][0] = n1;
            dice[1][1] = n2;
            dice[1][2] = n3;
            dice[3][1] = n4;
        }
        else if(cmd ==3){
            int[]arr = new int[4];
            for(int i = 0;i<4;i++){
                arr[i] = dice[(i+1)%4][1];
            }
            for(int i = 0;i<4;i++){
                dice[i][1] = arr[i];
            }
        }
        else if(cmd ==4) {
            int[]arr = new int[4];
            for(int i = 0;i<4;i++){
                arr[i] = dice[(i+3)%4][1];
            }
            for(int i = 0;i<4;i++){
                dice[i][1] = arr[i];
            }
        }
    }
    static void go(int cmd){
        int nx = x + dist[cmd-1][0];
        int ny = y + dist[cmd-1][1];
        if(nx <0 || ny<0 ||nx >= n||ny >= m)
            return;
        rotate(cmd);
        if(map[nx][ny] == 0){
            map[nx][ny] = dice[3][1];
        }else{
            dice[3][1] = map[nx][ny];
            map[nx][ny] = 0;
        }
        System.out.println(dice[1][1]);
        x = nx;
        y = ny;
    }
    public static void main(String[]args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine()," ");
        while(st.hasMoreTokens()) {
            int cmd = Integer.parseInt(st.nextToken());
            go(cmd);
        }

    }
}
