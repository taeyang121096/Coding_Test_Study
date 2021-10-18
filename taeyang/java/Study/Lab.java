import java.util.*;
import java.io.*;
public class Lab {
    static class Point{
        int row;
        int col;
        public Point(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    static int[][] mat;
    static ArrayList<Point> list = new ArrayList<>();
    static ArrayList<Point[]> three = new ArrayList<>();
    static void make(){
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 0)
                    list.add(new Point(i,j));
            }
        }
    }
    static void caseby(int level,int start,Point[] tmp){
        if(level == 3){
            Point[] rest = tmp.clone();
            three.add(rest);
            return;
        }
        for(int i = start;i<list.size();i++){
            tmp[level] = list.get(i);
            caseby(level+1,i+1,tmp);
        }
    }
    static boolean[][] check;
    static int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
    static void spray(int row,int col){
        Deque<Point> q = new ArrayDeque<>();
        q.offer(new Point(row,col));
        while(!q.isEmpty()){
            Point tmp = q.poll();
            if(check[tmp.row][tmp.col])
                continue;
            check[tmp.row][tmp.col] = true;
            for(int i = 0;i<4;i++){
                int nr = tmp.row + dist[i][0];
                int nc = tmp.col + dist[i][1];
                if(nr >=0 && nr < mat.length && nc >= 0 && nc < mat[0].length&& mat[nr][nc] != 1&& check[nr][nc] != true)
                    q.offer(new Point(nr,nc));
            }
        }
    }
    static int ans = 0;
    static int counting = 0;
    static void count(int row, int col){
        Deque<Point> q = new ArrayDeque<>();
        q.offer(new Point(row,col));
        while(!q.isEmpty()){
            Point tmp = q.poll();
            if(check[tmp.row][tmp.col])
                continue;
            counting++;
            check[tmp.row][tmp.col] = true;
            for(int i = 0;i<4;i++){
                int nr = tmp.row + dist[i][0];
                int nc = tmp.col + dist[i][1];
                if(nr >=0 && nr < mat.length && nc >= 0 && nc < mat[0].length&& mat[nr][nc] == 0&& check[nr][nc] != true)
                    q.offer(new Point(nr,nc));
            }
        }
    }
    static void change(){
        for(Point[]p: three){
            counting = 0;
            check = new boolean[mat.length][mat[0].length];
            mat[p[0].row][p[0].col] = 1;
            mat[p[1].row][p[1].col] = 1;
            mat[p[2].row][p[2].col] = 1;

            for(int i = 0;i<mat.length;i++){
                for(int j = 0;j<mat[0].length;j++){
                    if(mat[i][j] == 2 && check[i][j] != true)
                        spray(i,j);
                }
            }


            for(int i = 0;i<mat.length;i++){
                for(int j = 0;j<mat[0].length;j++){
                    if(mat[i][j] == 0 && check[i][j] == false)
                        count(i,j);
                }
            }

            ans = Math.max(ans,counting);


            mat[p[0].row][p[0].col] = 0;
            mat[p[1].row][p[1].col] = 0;
            mat[p[2].row][p[2].col] = 0;
        }
    }
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        mat = new int[n][m];


        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0;j<m;j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        make();
        caseby(0,0,new Point[3]);
        change();
        System.out.println(ans);

    }
}
