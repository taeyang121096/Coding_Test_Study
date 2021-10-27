package BOJ.samsungSW;
import java.util.*;
import java.io.*;
public class _15684 {
  static int N,M,H;
  static boolean[][] line;
  static int answer=-1;
  static boolean end = false;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    line = new boolean[N][H];

    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine()," ");
      int x=Integer.parseInt(st.nextToken());
      int y=Integer.parseInt(st.nextToken());
      line[y-1][x-1]=true;
    }
    
    for(int i=0; i<=3; i++){
      makeline(0,i);
    }
    System.out.println(answer);
  }

  public static void makeline(int select, int index){
    if(end) return;
    
    if(select == index){
      check(index);
      return;
    }

    for(int i=0; i<N-1; i++){
      for(int j=0; j<H; j++){
        if(!line[i][j]){
          line[i][j]=true;
          makeline(select+1, index);
          line[i][j]=false;     
        }
      }
    }
  }

  public static void check(int index){
    
    for(int i=0; i<N; i++){
      int x = i;
      int y = 0;
      while( y < H){
        if(x<N && line[x][y]){    // 오른쪽 이동 체크
          x++;
        }else if(x-1>=0 && line[x-1][y]){   // 왼쪽 이동 체크
          x--;
        }
        y++;
        
      }
      if(x != i) return; 
    }

    end=true;
    answer = index;
    return;
  }
}
