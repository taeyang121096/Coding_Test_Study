package BOJ.samsungSW;
import java.io.*;
import java.util.*;
public class _12100 {
  
  static int max=0;
  static int n;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n= Integer.parseInt(br.readLine());
    int[][] board=new int[n][n];
    boolean[][] merge=new boolean[n][n];
    
    for(int i=0; i<n; i++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      for(int j=0; j<n; j++){
        board[i][j]=Integer.parseInt(st.nextToken());
        max=Math.max(max,board[i][j]);
      }
    }
  
    for(int i=0; i<4; i++){
      move(i,0,board);
    }
    System.out.println(max);
  }
  public static void move(int index, int count, int[][] Board){
    if(count == 5 ) return;

    int[][] board = new int[n][n];
    boolean[][] merge= new boolean[n][n];
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        board[i][j]=Board[i][j];
      }
    }

    if(index==0){        // 상
      for(int i=0; i<n; i++){
        for(int j=1; j<n; j++){
          
          if(board[j][i]!=0){
            for(int k=j-1; k>=0; k--){
              
              if(board[k][i]!=0){
                if(board[k][i]==board[j][i] && (!merge[k][i] && !merge[j][i])) {
                  board[k][i]=board[k][i]*2;
                  max=Math.max(board[k][i],max);
                  merge[k][i]=true;
                  board[j][i]=0;
                }
                else{
                  if(j==k+1) break;
                  else {
                    board[k+1][i]=board[j][i];
                    merge[k+1][i]=merge[j][i];
                    merge[j][i]=false;
                    board[j][i]=0;
                  }
                }
                break;
              }
              if(k==0 && board[k][i]==0){ // 위로 전부 0인 경우
                board[k][i]=board[j][i];
                merge[k][i]=merge[j][i];
                merge[j][i]=false;
                board[j][i]=0;
              }
            }
          }
        }
      }
    }else if(index==1){   // 하
      for(int i=0; i<n; i++){
        for(int j=n-2; j>=0; j--){
          
          if(board[j][i]!=0){
            for(int k= j+1; k<n; k++){
              if(board[k][i]!=0){
                if(board[k][i]==board[j][i] && (!merge[k][i] && !merge[j][i])){
                  board[k][i]=board[k][i]*2;
                  max=Math.max(board[k][i],max);
                  merge[k][i]=true;
                  board[j][i]=0;
                }else{
                  if(j==k-1) break;
                  else{
                    board[k-1][i]=board[j][i];
                    merge[k-1][i]=merge[j][i];
                    merge[j][i]=false;
                    board[j][i]=0;
                  }
                }
                break;
              }
              if(k==n-1 && board[k][i]==0){ // 아래로 전부 0인 경우
                board[k][i]=board[j][i];
                merge[k][i]=merge[j][i];
                merge[j][i]=false;
                board[j][i]=0;
              }

            }
          }
        }
      }
    }else if(index==2){    // 좌
     for(int i=0; i<n; i++){
        for(int j=1; j<n; j++){
          
          if(board[i][j]!=0){
            for(int k=j-1; k>=0; k--){
              
              if(board[i][k]!=0){
                if(board[i][k]==board[i][j] && (!merge[i][k] && !merge[i][j])) {
                  board[i][k]=board[i][k]*2;
                  max=Math.max(board[i][k],max);
                  merge[i][k]=true;
                  board[i][j]=0;
                }
                else{
                  if(j==k+1) break;
                  else {
                    board[i][k+1]=board[i][j];
                    merge[i][k+1]=merge[i][j];
                    merge[i][j]=false;
                    board[i][j]=0;
                  }
                }
                break;
              }
              if(k==0 && board[i][k]==0){ // 왼쪽이 전부 0인 경우
                board[i][k]=board[i][j];
                merge[i][k]=merge[i][j];
                merge[i][j]=false;
                board[i][j]=0;
              }
            }
          }
        }
      }
    }else{                  // 우
      for(int i=0; i<n; i++){
        for(int j=n-2; j>=0; j--){
          
          if(board[i][j]!=0){
            for(int k= j+1; k<n; k++){
              if(board[i][k]!=0){
                if(board[i][k]==board[i][j] && (!merge[i][k] && !merge[i][j])){
                  board[i][k]=board[i][k]*2;
                  max=Math.max(board[i][k],max);
                  merge[i][k]=true;
                  board[i][j]=0;
                }else{
                  if(j==k-1) break;
                  else{
                    board[i][k-1]=board[i][j];
                    merge[i][k-1]=merge[i][j];
                    merge[i][j]=false;
                    board[i][j]=0;
                  }
                }
                break;
              }
              if(k==n-1 && board[i][k]==0){ // 오른쪽이 전부 0인 경우
                board[i][k]=board[i][j];
                merge[i][k]=merge[i][j];
                merge[i][j]=false;
                board[i][j]=0;
              }

            }
          }
        }
      }
    }
    
    for(int i=0; i<4; i++){
      move(i,count+1,board);
    }
  }

}
