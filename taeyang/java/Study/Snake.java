import java.util.*;
import java.io.*;
public class Snake {
    static int[][] mat;
    static int ans = 0;
    static int t = 0;
    static boolean flag = false;
//    상하좌우
    static int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};

    static class  Point{
        int row;
        int col;
        public Point(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    static Deque<Point> q = new ArrayDeque<>();

    static void game(int time,int dis){
        if(flag)
            return;
        Point p = q.peekFirst();
        int nr = p.row;
        int nc = p.col;
        for(int i = 0;i<time-t;i++){
            nr += dist[dis][0];
            nc += dist[dis][1];
            if(nr < 1 || nc <1 || nr> mat.length-1 || nc > mat.length -1 || mat[nr][nc] ==2 ){
                flag = true;
                return;
            }
            if(mat[nr][nc] != 1){
                Point l = q.pollLast();
                mat[l.row][l.col] = 0;
            }
            ans++;
            mat[nr][nc] = 2;
            q.offerFirst(new Point(nr,nc));

        }
        t =ans;
    }

    static int direct(String cmd,int dir){
//        왼쪽
        if(cmd.equals("L")){
            if(dir == 0)
                return 2;
            if(dir == 1)
                return 3;
            if(dir == 2)
                return 1;
            if(dir == 3)
                return 0;
        }
//        오른쪽
        else{
            if(dir == 0)
                return 3;
            if(dir == 1)
                return 2;
            if(dir == 2)
                return 0;
            if(dir == 3)
                return 1;
        }
        return -1;
    }

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        mat = new int[n+1][n+1];
        Arrays.fill(mat[0],-1);
        for(int j=0;j<n+1;j++)
            mat[j][0] = -1;
        for(int i = 0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            mat[row][col] = 1;
        }

        mat[1][1] = 2;

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        q.offer(new Point(1,1));
        int cmd = 3;
        for(int i = 0;i<l;i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String comm = st.nextToken();
            game(time,cmd);
            cmd = direct(comm,cmd);
        }
        if(flag != true){
            game(10000,cmd);
        }
        System.out.println(ans+1);

    }
}
