package BOJ;
import java.io.*;
import java.util.*;

public class _17070 {
  
  static int[][] arr;
  static int[] dx={0,1,1};
  static int[] dy={1,1,0};
  static int answer=0;
  static int N;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    arr=new int[N+1][N+1];
    for(int i=1; i<=N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      for(int j=1; j<=N; j++){
        arr[i][j]=Integer.parseInt(st.nextToken());
      }
    }

    move(1,1,1,2,0);

    System.out.println(answer);
  }

  public static void move(int x1, int y1, int x2, int y2, int mode){
    if(x2==N && y2==N){
      answer++;
      return;
    }
    
    if(mode==0){  // 가로
      for(int i=0; i<2; i++){
        int X=x2+dx[i];
        int Y=y2+dy[i];
        if(X>N || Y>N) continue;

        if(i==0){ //오른쪽 이동
          if(arr[X][Y]==0){
            move(x2,y2,X,Y,0);
          }
        }else{   //대각선으로 이동
          if(arr[x2+1][y2] == 0 && arr[x2][y2+1]==0 && arr[X][Y]==0){
            move(x2,y2,X,Y,2);
          }
        }
      }

    }else if(mode==1){ //세로
      for(int i=1; i<3; i++){
        int X=x2+dx[i];
        int Y=y2+dy[i];
        if(X>N || Y>N) continue;

        if(i==1){  //대각선 이동
          if(arr[x2+1][y2] == 0 && arr[x2][y2+1]==0 && arr[X][Y]==0){
            move(x2,y2,X,Y,2);
          }
        }else{ //아래 이동
          if(arr[X][Y]==0){
            move(x2,y2,X,Y,1);
          }
        }

      }
    }else{ // 대각선
      for(int i=0; i<3; i++){
        int X=x2+dx[i];
        int Y=y2+dy[i];
        if(X>N || Y>N) continue;

        if(i==0){ //오른쪽 이동
          if(arr[X][Y]==0){
            move(x2,y2,X,Y,0);
          }
        }else if(i==1){  //대각선 이동
          if(arr[x2+1][y2] == 0 && arr[x2][y2+1]==0 && arr[X][Y]==0){
            move(x2,y2,X,Y,2);
          }
        }else{ //아래 이동
          if(arr[X][Y]==0){
            move(x2,y2,X,Y,1);
          }
        }
      }
    }
  } 
}
