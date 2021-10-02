package BOJ.basicCheck;
import java.io.*;
import java.util.*;
public class _2178 {

  static class node{
    int x;
    int y;
    int move;
    public node(int x, int y, int move){
      this.x=x;
      this.y=y;
      this.move=move;
    }
  }

  static int[] dx={1,-1,0,0};
  static int[] dy={0,0,1,-1};
  static boolean[][] visit;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str= br.readLine().split(" ");
    int N= Integer.parseInt(str[0]);
    int M= Integer.parseInt(str[1]);

    int[][] arr = new int[N][M];
    visit = new boolean[N][M];

    for(int i=0; i<N; i++){
      String[] tmp = br.readLine().split("");
      for(int j=0; j<M; j++){
        arr[i][j]=Integer.parseInt(tmp[j]);
      }
    }
    
    Queue<node> q= new LinkedList<>();
    q.add(new node(0,0,1));

    while(!q.isEmpty()){
      node tmp =q.poll();
      int tx=tmp.x;
      int ty=tmp.y;
      visit[tx][ty]=true;

      if(tx==N-1 && ty == M-1){
        System.out.println(tmp.move);
        return;
      } 

      for(int i=0; i<4; i++){
        int x = tx+dx[i];
        int y = ty+dy[i];

        if(x<0 || y<0|| x>=N || y>=M) continue;

        if(!visit[x][y] && arr[x][y]==1){
          visit[x][y]=true;
          q.add(new node(x,y,tmp.move+1));
        }
      }
    }
  }
}
