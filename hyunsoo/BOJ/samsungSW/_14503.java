package BOJ.samsungSW;
import java.io.*;
import java.util.*;
public class _14503 {

  static int n,m,r,c,d;
  static int[][] board;
  static boolean[][] visit;
  static int[] dx={0,-1,0,1};  // 방향에 따른 진행
  static int[] dy={-1,0,1,0};
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine()," ");
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    board = new int[n][m];
    visit = new boolean[n][m];
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine()," ");
      for(int j=0; j<m; j++){
        board[i][j]=Integer.parseInt(st.nextToken());
      }
    }
    int answer=1;
    
   
    while(true){

      visit[r][c]=true;
      
      if(allclear()){
        int k = d-1;
        if(k<0) k=3;
        int tx= r +dx[k];
        int ty= c+ dy[k];

        if(tx<0 || tx>=n || ty<0 || ty>=m) {        
          break;
        }
        if(board[tx][ty]==1) {
          break;
        }
        r=tx;
        c=ty;
        continue;
      }

      int tx = r+dx[d];
      int ty = c+dy[d];

      if(tx<0 || tx>=n || ty<0 || ty>=m){
        d--;
        if(d<0) d=3;
        continue;
      }

      if(board[tx][ty]==1 || visit[tx][ty]){
        d--;
        if(d<0) d=3;
        continue;
      }else{
        d--;
        if(d<0) d=3;
          
        r=tx;
        c=ty;
        answer++;
        continue;
      }
    }

    

    System.out.print(answer);
  }

  public static boolean allclear(){
    
    for(int i=0; i<4; i++){
      int tx = r+dx[i];
      int ty = c+dy[i];
      
      if(tx<0 || tx>=n || ty<0 || ty>=m) continue;
      if(board[tx][ty]==0 && !visit[tx][ty]) return false;
    }

    return true;
  }
}
