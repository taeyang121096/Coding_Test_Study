package BOJ.samsungSW;
import java.util.*;
import java.io.*;
public class _21608 {
  
  static int N;
  static int[][] arr;
  static int[][] favor;
  static int[] dx={0,0,1,-1};
  static int[] dy={1,-1,0,0};
  static List<Integer> list;

  static class node{
    int x;
    int y;
    public node(int x, int y){
      this.x=x;
      this.y=y;
    }
  }
  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N= Integer.parseInt(br.readLine());

    arr = new int[N+1][N+1];
    favor = new int[N*N][5];


    for(int i=0; i<N*N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      for(int j=0; j<5; j++){
        favor[i][j]=Integer.parseInt(st.nextToken());
      }
    }
  }

  public static void findBlack(int index){

    for(int i=1; i<=N; i++){
      for(int j=1; j<=N; j++){
        for(int k=0; k<4; k++){
          int tx = i+dx[i];
          int ty = j+dy[i];
          if(tx<0 || ty<0 || tx>N || ty>N) continue;

          arr[tx][ty]==
        }
      }
    }
  }

}
