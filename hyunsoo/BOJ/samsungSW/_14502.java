package BOJ.samsungSW;
import java.util.*;
import java.io.*;
public class _14502 {
  
  static int n,m;
  static int[][] board;
  static int[] dx={1,-1,0,0};
  static int[] dy={0,0,1,-1};
  static boolean[][] visit;
  static boolean[][] VirusTransition;
  static List<node> list = new LinkedList<>();
  static class node{
    int x;
    int y;
    public node(int x, int y){
      this.x=x;
      this.y=y;
    }
  }
  static int max;
  static int answer=0;
  static int countW=0;   // 벽 개수
  static int countV=0;   // 퍼진 바이러스 수
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][m];
    visit = new boolean[n][m];
    max=n*m;
    for(int i=0; i<n; i++){
      st= new StringTokenizer(br.readLine()," ");
      for(int j=0; j<m; j++){
        board[i][j]=Integer.parseInt(st.nextToken());
        if(board[i][j]==2){
          list.add(new node(i,j));
        }
      }
    }

    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(board[i][j]==0 && !visit[i][j]){
          visit[i][j]=true;
          makeWall(1);
          visit[i][j]=false;
        }
      }
    }
    
    System.out.println(answer);
  }

  public static void makeWall(int wall){   // 벽 세우기
    if(wall==3){
      VirusTransition = new boolean[n][m];
      transition();
      count();
      int tmp = max-countV-countW-3;
      answer=Math.max(answer,tmp);
      return;
    }

    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(board[i][j]==0 && !visit[i][j]){
          visit[i][j]=true;
          makeWall(wall+1);
          visit[i][j]=false;
        }
      }
    }
    
  }
  public static void count(){    // 벽 개수 세기
    countW=0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(board[i][j]==1){
          countW++;
        }
      }
    }
  }

  public static void transition(){    // 바이러스 퍼지기
    Queue<node> virus = new LinkedList<>();
    countV=0;
    for(int i=0; i<list.size(); i++){
      node no = list.get(i);
      virus.add(no);
    }

    while(!virus.isEmpty()){
      node tmp = virus.poll();
      countV++;
      for(int i=0; i<4; i++){
        int tx = tmp.x+dx[i];
        int ty = tmp.y+dy[i];

        if(tx<0 || ty<0 || tx >= n || ty>=m) continue;

        if(board[tx][ty]==0 && !VirusTransition[tx][ty] && !visit[tx][ty]){
          VirusTransition[tx][ty]=true;
          virus.offer(new node(tx,ty));
        }
      }
    }
  }
}
