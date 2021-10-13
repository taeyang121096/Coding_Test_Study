package BOJ.samsungSW;
import java.util.*;
import java.io.*;
public class _3190 {
  static int[][] apple;
  static boolean[][] snake;
  static int time=0;
  static int n;
  static boolean fail=false;
  static ArrayDeque<node> dq = new ArrayDeque<>();
  static String[][] move;
  static int mode=0; //첫 시작은 오른쪽
  // 0 = 오른쪽 1 = 왼쪽, 2 = 위 , 3 = 아래

  public static class node{
    int x;
    int y;
    public node(int x, int y){
      this.x=x;
      this.y=y;
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());
    
    apple = new int[n+1][n+1];
    snake = new boolean[n+1][n+1];

    for(int i=0; i<k; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      apple[a][b]=1;
    }
    snake[1][1]=true;
    dq.add(new node(1,1));
    
    int m= Integer.parseInt(br.readLine());
    move=new String[m][2];
    for(int i=0; i<m; i++){
      move[i]= br.readLine().split(" ");     
    }

    start();    

    System.out.println(time+1);
  }

  public static void start(){
    
    int i=0;
    while(true){
      if( i<move.length && time==Integer.parseInt(move[i][0])){
        changeDirect(move[i][1]);
        i++;
      }
      
      node head = dq.peekFirst();
      //System.out.println(head.x+" "+head.y+" "+time);
      if(mode==0){  //오른쪽
        int x= head.x;
        int y= head.y+1;

        if(y>n  || snake[x][y]) {fail=true; return;}
        dq.addFirst(new node(x,y));
        snake[x][y]=true;
        time++;

        if(apple[x][y]!=1){ 
          node last= dq.pollLast();
          snake[last.x][last.y]=false;
        }else{
          apple[x][y]=0;
        }

      }else if(mode==1){  // 왼쪽
        int x= head.x;
        int y= head.y-1;

        if( y<1  || snake[x][y]) {fail=true; return;}
        dq.addFirst(new node(x,y));
        snake[x][y]=true;
        time++;

        if(apple[x][y]!=1){ 
          node last= dq.pollLast();
          snake[last.x][last.y]=false;
        }else{
          apple[x][y]=0;
        }
      }else if(mode==2){  // 위
        int x= head.x-1;
        int y= head.y;
        if(x<1 || snake[x][y]) {fail=true; return;}
        dq.addFirst(new node(x,y));
        snake[x][y]=true;
        time++;

        if(apple[x][y]!=1){ 
          node last= dq.pollLast();
          snake[last.x][last.y]=false;
        }else{
          apple[x][y]=0;
        }
      }else{  // 아래
        int x= head.x+1;
        int y= head.y;
        if(x>n || snake[x][y]) {fail=true; return;}
        dq.addFirst(new node(x,y));
        snake[x][y]=true;
        time++;

        if(apple[x][y]!=1){ 
          node last= dq.pollLast();
          snake[last.x][last.y]=false;
        }else{
          apple[x][y]=0;
        }
      }
     
    }
  }

  public static void changeDirect(String str){
    // 0 = 오른쪽 1 = 왼쪽, 2 = 위 , 3 = 아래
    if(str.equals("L")){
      //System.out.println("좌회전");
      if(mode==0){
        mode=2;
      }else if(mode==1){
        mode=3;
      }else if(mode==2){
        mode=1;
      }else if(mode==3){
        mode=0;
      }
    }else{
      //System.out.println("우회전");
      if(mode==0){
        mode=3;
      }else if(mode==1){
        mode=2;
      }else if(mode==2){
        mode=0;
      }else if(mode==3){
        mode=1;
      }
    }
  }

}
