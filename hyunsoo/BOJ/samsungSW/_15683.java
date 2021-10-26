package BOJ.samsungSW;
import java.util.*;
import java.io.*;
public class _15683 {
  
  static int N,M;
  static int area=0;
  static int[][] board;
  static List<node> list = new ArrayList<>();
  static List<made> mlist = new ArrayList<>();
  static int[] dx = {0,1,0,-1};
  static int[] dy = {1,0,-1,0};
  static int min = Integer.MAX_VALUE;

  static class node{
    int x;
    int y;
    public node(int x, int y){
      this.x=x;
      this.y=y;
    }
  }

  static class made{
    node code;
    int type;
    int direct;
    public made(node code , int type, int direct){
      this.code = code;
      this.type = type;
      this.direct = direct;
    }

  }
  public static void main(String[] arg) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    N= Integer.parseInt(st.nextToken());
    M= Integer.parseInt(st.nextToken());
    board = new int[N][M];

    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine()," ");
      for(int j=0; j<M; j++){
        board[i][j] = Integer.parseInt(st.nextToken());
        if( board[i][j] != 0 && board[i][j] != 6 ){
            list.add(new node(i,j));
        }
        if(board[i][j]==0) area ++; 
      }
    }
    made(0);

    System.out.print(min);
  } 
  
  public static void made(int index){
    
    // 1  4가지 방향 , 2 번때 2가지, 3번 4개 , 4 번 4개,  5번 1
    if(index== list.size()){
      int ans = count();
      min = Math.min(min, area - ans);
      return;
    }
    node tmp = list.get(index);

    if(board[tmp.x][tmp.y]==1){
      for(int i=0; i<4; i++){
        mlist.add(new made(tmp, 1, i));
        made(index+1);
        mlist.remove(mlist.size()-1);
      }
    }else if(board[tmp.x][tmp.y]==2){
      for(int i=0; i<2; i++){
        mlist.add(new made(tmp, 2, i));
        made(index+1);
        mlist.remove(mlist.size()-1);
      }
    }else if(board[tmp.x][tmp.y]==3){
       for(int i=0; i<4; i++){
        mlist.add(new made(tmp, 3, i));
        made(index+1);
        mlist.remove(mlist.size()-1);
      } 
    }else if(board[tmp.x][tmp.y]==4){
      for(int i=0; i<4; i++){
        mlist.add(new made(tmp, 4, i));
        made(index+1);
        mlist.remove(mlist.size()-1);
      } 
    }else{
      mlist.add(new made(tmp, 5, 0));
      made(index+1);
      mlist.remove(mlist.size()-1); 
    }
  }

  public static int count(){

    boolean[][] visit = new boolean[N][M];
    int count=0;  
    for(int i=0; i<mlist.size(); i++){
      made tmp = mlist.get(i);
      int tx= tmp.code.x;
      int ty= tmp.code.y;
      
      if(tmp.type == 1 ){  
        int x1= tx;
        int y1= ty;
        while(true){
          x1 = x1+ dx[tmp.direct];
          y1 = y1+ dy[tmp.direct];

          if(x1<0 || y1<0  || x1>=N || y1>=M) break;
          if(board[x1][y1] == 6) break;
          
          if(visit[x1][y1] || board[x1][y1] != 0) continue;

          visit[x1][y1]= true;
          count++;
        }

      }else if(tmp.type==2){
        int x1 = tx;
        int y1 = ty;
        int x2 = tx;
        int y2 = ty;
     
        while(true){
          x1 = x1 + dx[tmp.direct];
          y1 = y1 + dy[tmp.direct];
          
          if(x1<0 || y1<0  || x1>=N || y1>=M) break;
          if(board[x1][y1] == 6) break;
          
          if(visit[x1][y1] || board[x1][y1] != 0 ) continue;

          visit[x1][y1]= true;
          count++;
        }
        while(true){
          x2 = x2 + dx[tmp.direct+2];
          y2 = y2 + dy[tmp.direct+2];
          
          if(x2<0 || y2<0  || x2>=N || y2>=M) break;
          if(board[x2][y2] == 6) break;
          
          if(visit[x2][y2] || board[x2][y2] != 0 ) continue;

          visit[x2][y2]= true;
          count++;
        }
      }else if(tmp.type==3){
        int x1 = tx;
        int y1 = ty; 
        int x2 = tx;
        int y2 = ty;
        
        while(true){
          x1 = x1 + dx[tmp.direct];
          y1 = y1 + dy[tmp.direct];
          
          if(x1<0 || y1<0  || x1>=N || y1>=M) break;
          if(board[x1][y1] == 6) break;
          
          if(visit[x1][y1] || board[x1][y1] != 0) continue;

          visit[x1][y1]= true;
          count++;
        }
        while(true){
          x2 = x2 + dx[(tmp.direct+1)%4];
          y2 = y2 + dy[(tmp.direct+1)%4];
          
          if(x2<0 || y2<0  || x2>=N || y2>=M) break;
          if(board[x2][y2] == 6) break;
          
          if(visit[x2][y2] || board[x2][y2] != 0) continue;

          visit[x2][y2]= true;
          count++;
        }
      }else if(tmp.type==4){
        int x1 = tx;
        int y1 = ty;
        int x2 = tx;
        int y2 = ty;
        int x3 = tx;
        int y3 = ty;
        
        while(true){
          x1 = x1 + dx[tmp.direct];
          y1 = y1 + dy[tmp.direct];
          
          if(x1<0 || y1<0  || x1>=N || y1>=M) break;
          if(board[x1][y1] == 6) break;
          
          if(visit[x1][y1] || board[x1][y1] != 0) continue;

          visit[x1][y1]= true;
          count++;
        }
        while(true){
          x2 = x2 + dx[(tmp.direct+1)%4];
          y2 = y2 + dy[(tmp.direct+1)%4];
          
          if(x2<0 || y2<0  || x2>=N || y2>=M) break;
          if(board[x2][y2] == 6) break;
          
          if(visit[x2][y2] || board[x2][y2] != 0) continue;

          visit[x2][y2]= true;
          count++;
        }
        while(true){
          x3 = x3 + dx[(tmp.direct+2)%4];
          y3 = y3 + dy[(tmp.direct+2)%4];
          
          if(x3<0 || y3<0  || x3>=N || y3>=M) break;
          if(board[x3][y3] == 6) break;
          
          if(visit[x3][y3] || board[x3][y3] != 0) continue;

          visit[x3][y3]= true;
          count++;
        }
      }else{
        int x1 = tx;
        int y1 = ty;
        int x2 = tx;
        int y2 = ty;
        int x3 = tx;
        int y3 = ty;
        int x4 = tx;
        int y4 = ty;
        
        while(true){
          x1 = x1 + dx[tmp.direct];
          y1 = y1 + dy[tmp.direct];
          
          if(x1<0 || y1<0  || x1>=N || y1>=M) break;
          if(board[x1][y1] == 6) break;
          
          if(visit[x1][y1] || board[x1][y1] != 0) continue;

          visit[x1][y1]= true;
          count++;
        }
        while(true){
          x2 = x2 + dx[(tmp.direct+1)%4];
          y2 = y2 + dy[(tmp.direct+1)%4];
          
          if(x2<0 || y2<0  || x2>=N || y2>=M) break;
          if(board[x2][y2] == 6) break;
          
          if(visit[x2][y2] || board[x2][y2] != 0 ) continue;

          visit[x2][y2]= true;
          count++;
        }
        while(true){
          x3 = x3 + dx[(tmp.direct+2)%4];
          y3 = y3 + dy[(tmp.direct+2)%4];
          
          if(x3<0 || y3<0  || x3>=N || y3>=M) break;
          if(board[x3][y3] == 6) break;
          
          if(visit[x3][y3] || board[x3][y3] != 0) continue;

          visit[x3][y3]= true;
          count++;
        }
        while(true){
          x4 = x4 + dx[(tmp.direct+3)%4];
          y4 = y4 + dy[(tmp.direct+3)%4];
          
          if(x4<0 || y4<0  || x4>=N || y4>=M) break;
          if(board[x4][y4] == 6) break;
          
          if(visit[x4][y4] || board[x4][y4] != 0) continue;

          visit[x4][y4]= true;
          count++;
        }
      }
    }

    return count;
  }
}
