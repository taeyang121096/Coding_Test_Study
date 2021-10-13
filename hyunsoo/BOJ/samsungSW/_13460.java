package BOJ.samsungSW;
import java.util.*;
import java.io.*;
public class _13460 {
    
  static class node{
    int rx;
    int ry;
    int bx;
    int by;
    int move;
    public node(int rx, int ry, int bx, int by,int move){
      this.rx=rx;
      this.ry=ry;
      this.bx=bx;
      this.by=by;
      this.move=move;
    }
  }
  static boolean success=false;
  static int answer=-1;
  static char[][] board;
  static int[] dx={1,-1,0,0};
  static int[] dy={0,0,1,-1};
  static boolean[][][][] visit; 

  static Queue<node> q= new LinkedList<>();
  public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] tmp = br.readLine().split(" ");
      int N = Integer.parseInt(tmp[0]);
      int M = Integer.parseInt(tmp[1]);
      visit=new boolean[N][M][N][M];
      board= new char[N][M];
      int rx=0,ry=0,bx=0,by=0;
      for(int i=0; i<N; i++){
        String t = br.readLine();
        for(int j=0; j<M; j++){
          board[i][j]=t.charAt(j);
          if(board[i][j]=='B'){
            bx=i;
            by=j;
            board[i][j]='.';
          }
          if(board[i][j]=='R'){
            rx=i;
            ry=j;
            board[i][j]='.';
          }
        }
      }
      visit[rx][ry][bx][by]=true;
      node master = new node(rx,ry,bx,by,0);
      q.offer(master);
      while(!q.isEmpty()){
        node t = q.poll();
        int _rx=t.rx;
        int _ry=t.ry;
        int _bx=t.bx;
        int _by=t.by;
        int _move=t.move;
        //System.out.println(_rx+":"+_ry+" , "+_bx+":"+_by+"=" +_move);
        if(_move>=10){
          System.out.println(answer);
          return;
        }
        
        for(int i=0; i<4; i++){    
          move(_rx,_ry,_bx,_by,_move,i);
          if(success){
            System.out.println(answer);
            return;
          }
        }
      }
      System.out.println(answer);
  }

  public static void move(int rx, int ry, int bx, int by,int move, int mode){
    
    int _rx=rx;
    int _ry=ry;
    int _bx=bx;
    int _by=by;

    while(true){
      int Rx= _rx + dx[mode];
      int Ry= _ry + dy[mode];
      int Bx= _bx + dx[mode];
      int By= _by + dy[mode];
      if(visit[Rx][Ry][Bx][By]) {  //이미 방문했던 곳이면 빠져나옴
        return;
      }  

      if(board[Bx][By]=='O') return;  // 파란공이 빠지면 빠져나옴
      else if(board[Rx][Ry]=='O'){   // 빨간공이 빠졌을 때, 해당 움직임에서 파란공도 같이 빠지는지를 파악
        while(true){
          if(board[Bx][By]=='#'){    //파란공이 벽을 만남 => 성공
            success=true;
            answer= move+1;
            break;
          }else if(board[Bx][By]=='O'){  // 빨간공과 파란공이 같이 빠짐
            break;
          }
          Bx+=dx[mode];
          By+=dy[mode];
        }
        return;
      }else if(board[Rx][Ry]=='.' && board[Bx][By]=='.' && (!visit[Rx][Ry][Bx][By])){  //둘다 이동 가능하고 빨간공과 파란공 중 한개라도 이미 방문하지 않은 곳인 경우
        _rx=Rx;
        _ry=Ry;
        _bx=Bx;
        _by=By;
      }else if(board[Rx][Ry]=='.'){  // 빨간 공만 이동 가능한 경우
        if(Rx==_bx && Ry==_by){  // 빨간 공이 이동 가능한데 그 자리에 파란공이 있는 경우
          if(!visit[_rx][_ry][_bx][_by]){  // 방문하지 않은 곳이라면 
            visit[_rx][_ry][_bx][_by]=true;
            q.offer(new node(_rx,_ry,_bx,_by,move+1));
          }
          return; 
        }else{
          _rx=Rx;
          _ry=Ry;
        }
      }else if(board[Bx][By]=='.'){  // 파란 공만 이동 가능한 경우
        if(Bx==_rx && By == _ry){ //파란 공이 이동 가능한데 그 자리에 빨간공이 있는 경우
          if(!visit[_rx][_ry][_bx][_by]){  // 방문하지 않은 곳이라면 
            visit[_rx][_ry][_bx][_by]=true;
            q.offer(new node(_rx,_ry,_bx,_by,move+1));
          }
          return; 
        }else{  
          _bx=Bx;
          _by=By;
        }
      }else{    //둘다 막혔을 경우
         if(!visit[_rx][_ry][_bx][_by]){  // 방문하지 않은 곳이라면 
            visit[_rx][_ry][_bx][_by]=true;
            q.offer(new node(_rx,_ry,_bx,_by,move+1));
          }
          return; 
      } 
    }
  }
}
