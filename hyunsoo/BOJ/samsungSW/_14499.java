package BOJ.samsungSW;
import java.util.*;
import java.io.*;
public class _14499 {

  static int[][] board;
  static int[][] dice;
  static int N,M,x=0,y=0;
  static int[] dx={0,0,-1,1};  //동, 서 ,북, 남
  static int[] dy={1,-1,0,0};
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    for(int i=0; i<N; i++){
      st=new StringTokenizer(br.readLine()," ");
      for(int j=0; j<M; j++){
        board[i][j]=Integer.parseInt(st.nextToken());
      }
    }

    dice = new int[4][3];
    
    st=new StringTokenizer(br.readLine()," ");
    for(int i=0; i<K; i++){
      move(Integer.parseInt(st.nextToken()));
    }
    System.out.println(sb.toString());

  }
  public static void move(int mode){
    
    int tx = x+dx[mode-1];
    int ty = y+dy[mode-1];

    if(tx<0 || tx>=N || ty<0 || ty>=M) return;

    if(mode==1){      // 동
      if(board[tx][ty]==0){
        board[tx][ty]=dice[1][2];
      }else{
        dice[1][2]=board[tx][ty];
        board[tx][ty]=0;
      }
      int tmp = dice[1][2];
      dice[1][2] = dice[3][1];
      dice[3][1] = dice[1][0];
      dice[1][0]=dice[1][1];
      dice[1][1]=tmp;
    }else if(mode==2){  // 서
      if(board[tx][ty]==0){
        board[tx][ty]=dice[1][0];
      }else{
        dice[1][0]=board[tx][ty];
        board[tx][ty]=0;
      }
      int tmp = dice[1][0];
      dice[1][0]=dice[3][1];
      dice[3][1]=dice[1][2];
      dice[1][2]=dice[1][1];
      dice[1][1]=tmp;  
    }else if(mode==3){  // 북
      if(board[tx][ty]==0){
        board[tx][ty]=dice[0][1];
      }else{
        dice[0][1]=board[tx][ty];
        board[tx][ty]=0;
      }
      int tmp = dice[3][1];
      dice[3][1]=dice[2][1];
      dice[2][1]=dice[1][1];
      dice[1][1]=dice[0][1];
      dice[0][1]=tmp;
    }else if(mode==4){  // 남

      if(board[tx][ty]==0){
        board[tx][ty]=dice[2][1];
      }else{
        dice[2][1]=board[tx][ty];
        board[tx][ty]=0;
      }
      int tmp = dice[3][1];
      dice[3][1]=dice[0][1];
      dice[0][1]=dice[1][1];
      dice[1][1]=dice[2][1];
      dice[2][1]=tmp;
    
    }

    x=tx;
    y=ty;
    sb.append(dice[3][1]+"\n");


  }
}
