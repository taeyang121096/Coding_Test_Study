package hyunsoo.BOJ.samsungSW;
import java.util.*;
import java.io.*;
public class _13460 {
    
  static class node{
    int x;
    int y;
    node R;
    node B;
    int move;
    public node(int x, int y){
      this.x=x;
      this.y=y;
    }
    public node(node R, node B, int move){
      this.R=R;
      this.B=B;
      this.move=move;
    }
  }
  static node blue;
  static node red;
  static node hole;
  static char[][] board;
  static int[] dx={1,-1,0,0};
  static int[] dy={0,0,1,-1};
  static boolean[][] Cred;
  static boolean[][] Cblue;
  public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] tmp = br.readLine().split(" ");
      int N = Integer.parseInt(tmp[0]);
      int M = Integer.parseInt(tmp[1]);
      Cred=new boolean[N][M];
      Cblue=new boolean[N][M];
      board= new char[N][M];
      for(int i=0; i<M; i++){
        String t = br.readLine();
        for(int j=0; j<N; j++){
          board[i][j]=t.charAt(j);
          if(board[i][j]=='B'){
            blue = new node(i,j);
            board[i][j]='.';
          }
          if(board[i][j]=='R'){
            red= new node(i,j);
            board[i][j]='.';
          }
          if(board[i][j]=='O'){
            hole=new node(i,j);
          }
        }
      } 
      
      node master = new node(red,blue,0);
      Queue<node> q= new LinkedList<>();
      q.offer(master);

      while(!q.isEmpty()){
        node t = q.poll();
        int rx=t.R.x;
        int ry=t.R.y;
        int bx=t.B.x;
        int by=t.B.y;
        System.out.println(rx+":"+ry+","+bx+":"+by);
        if(t.move>10) {
          System.out.print(-1);
          return;
        }
        Cred[rx][ry]=true;
        Cblue[bx][by]=true;
        
        for(int i=0; i<4; i++){
          int Rx= rx+dx[i];
          int Ry= ry+dy[i];
          int Bx= bx+dx[i];
          int By= by+dy[i];

          if(board[Bx][By]=='O'){  //blue가 홀에 빠진 경우
            continue; 
          }else if(board[Rx][Ry]=='O'){
            System.out.println(t.move+1);
            return;
          }    
          else if(board[Rx][Ry]=='.' && board[Bx][By]=='.' && (!Cred[Rx][Ry] || !Cblue[Rx][Ry])){ //둘다 이동가능한 경우  
            q.offer(new node(new node(Rx,Ry),new node(Bx,By),t.move+1));
          }else if(board[Rx][Ry]=='.' && !Cred[Rx][Ry]){   // red만 이동가능한경우
            if(Rx==bx && Ry==by) continue;
            q.offer(new node(new node(Rx,Ry),new node(bx,by),t.move+1)); 
          }else if(board[Bx][By]=='.' && !Cblue[Bx][By]){     // blue만 이동가능한 경우
            if(rx==Bx && ry==By) continue;
            q.offer(new node(new node(rx,ry),new node(Bx,By),t.move+1)); 
          }

      }

    }

  }
}
