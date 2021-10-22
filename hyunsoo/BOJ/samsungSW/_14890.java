package BOJ.samsungSW;
import java.util.*;
import java.io.*;
public class _14890 {
  
  static int N,L;
  static int[][] arr;
  static int answer=0;
  static boolean[] row;
  static boolean[] col;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st  = new StringTokenizer(br.readLine()," ");

    N= Integer.parseInt(st.nextToken());
    L= Integer.parseInt(st.nextToken());
    arr= new int[N][N];
    row = new boolean[N];
    col = new boolean[N];
    
    for(int i=0; i<N; i++){
      st= new StringTokenizer(br.readLine()," ");
      for(int j=0; j<N; j++){
        arr[i][j]=Integer.parseInt(st.nextToken());
      }
    }

    checkheight();
    usingslop();
    System.out.println(answer);
  }

  public static void usingslop(){
    for(int i=0; i<N; i++){
      if(!row[i]){
        boolean[] check = new boolean[N];  //경사로를 세움
        boolean suc=true;
        for(int j=1; j<N; j++){
          if(arr[i][j]-arr[i][j-1]==1){
            if(j-L<0) { suc=false; break;}
            for(int k=j-L; k<j; k++){
              if(check[k]) { suc=false; break;}
              check[k]=true;
            }
          }else if(arr[i][j]-arr[i][j-1]==-1){
            if(j+L-1>=N) { suc=false; break;}
            for(int k=j; k<j+L; k++){
              if(check[k]) { suc=false; break;}
              check[k]=true;
            }
          }
        }
        if(suc) answer++;
      }
    }

    for(int i=0; i<N; i++){
      if(!col[i]){
        boolean[] check = new boolean[N];  //경사로를 세움
        boolean suc=true;
        for(int j=1; j<N; j++){
          if(arr[j][i]-arr[j-1][i]==1){
            if(j-L<0) { suc=false; break;}
            for(int k=j-L; k<j; k++){
              if(check[k]) { suc=false; break;}
              check[k]=true;
            }
          }else if(arr[j][i]-arr[j-1][i]==-1){
            if(j+L-1>=N) { suc=false; break;}
            for(int k=j; k<j+L; k++){
              if(check[k]) { suc=false;
                 break;}
              check[k]=true;
            }
          }
        }
        if(suc) answer++;
      }
    }
  }

  public static void checkheight(){  // 높이가 전부 같은지 파악  , 높이가 2이상 차이 나지 않는지 파악
    for(int i=0; i<N; i++){
      int tmp = arr[i][0];
      boolean check = false;
      for(int j=1; j<N; j++){
        if(tmp!=arr[i][j]) check=true;
        if(Math.abs(arr[i][j]-arr[i][j-1])>1){
          row[i]=true;
          break;
        }
      }
      if(!check) {
        row[i]=true;
        answer++;
      }
    }

    for(int i=0; i<N; i++){
      int tmp = arr[0][i];
      boolean check = false;
      for(int j=1; j<N; j++){
        if(tmp!=arr[j][i]) {
          check=true;
        }
        if(Math.abs(arr[j][i]-arr[j-1][i])>1){
          col[i]=true;
          break;
        }
      }
      if(!check){ 
        col[i]=true;
        answer++;
      }
    }
  }

}
