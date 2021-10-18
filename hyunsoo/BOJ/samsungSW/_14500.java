package BOJ.samsungSW;
import java.io.*;
import java.util.*;

public class _14500 {
  static int N,M;
  static int[][] board;
  static boolean[][] visit;
  static int max=0;
  static int[] dx={1,-1,0,0};
  static int[] dy={0,0,1,-1};
  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    N= Integer.parseInt(st.nextToken());
    M= Integer.parseInt(st.nextToken());

    board = new int[N][M];
    visit = new boolean[N][M];

    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine()," ");
      for(int j=0; j<M; j++){
        board[i][j]=Integer.parseInt(st.nextToken());
      }
    }
    /**
     *  000
     *  000
     *  000
     * 
     * 
     */
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        if(!visit[i][j]){
          visit[i][j]=true;
          dfs(i,j,1,board[i][j]);
          visit[i][j]=false;
          except(i,j);
        }
      }
    }

    System.out.println(max);
  }
  public static void except(int a, int b){

    // ㅜ
    if( b+2<M && a+1 <N){
      int sum = board[a][b] + board[a][b+1] + board[a][b+2] + board[a+1][b+1];
      max=Math.max(sum,max);
    }
    // ㅓ
    if( a+1<N && a-1>=0 && b+1<M ){
      int sum = board[a][b] + board[a][b+1] + board[a+1][b+1] + board[a-1][b+1];
      max=Math.max(sum,max);
    }
    // ㅗ
    if( b+2 <M && a-1>=0 ){
      int sum = board[a][b] + board[a][b+1] + board[a][b+2] + board[a-1][b+1];
      max=Math.max(sum,max);
    }
    // ㅏ
    if(a-1>=0 && a+1 <N && b+1<M){
      int sum = board[a][b] + board[a-1][b] + board[a+1][b] + board[a][b+1];
      max=Math.max(sum,max);
    }
  }
  public static void dfs(int a, int b, int count,int sum){
    if(count==4){
      max= Math.max(max,sum);
      return;
    }
    for(int i=0; i<4; i++){
      int x = a + dx[i];
      int y = b + dy[i];

      if(x<0 || x>=N || y<0 || y>=M) continue;    
      if(!visit[x][y]){
        visit[x][y]=true;
        dfs(x,y,count+1, sum+board[x][y]);
        visit[x][y]=false;
      }
    }
  }
}
