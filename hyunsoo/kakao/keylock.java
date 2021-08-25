/**
 * 2020 KAKAO BLIND RECRUITMENT 자물쇠와 열쇠
 */
package kakao;

public class keylock {
  class Solution {
    int[][][] Keys;
    int M;
    int N;
    int[][] lotateKey(int[][] key){
        
        int[][] rotate = new int[M][M];
        for(int i=M-1, k=0; i>=0; i--){
            for(int j=0; j<M; j++){
                rotate[k][j] = key[j][i];
            }
            k++;
        }
        return rotate;
    }
  
    public boolean solved(int[][] solve){
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(solve[i][j]!=1) return false;
            }
        } 
        return true;        
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        
        M=key[0].length;
        N = lock[0].length;
        Keys=new int[4][M][M];
        Keys[0] = key;
        
        
        for(int i=1; i<4; i++) {
            Keys[i]=lotateKey(Keys[i-1]);
        }
        
        int start=1-M;
        int end=N;
        int[][] tmp= new int[N][N];
      
        for(int i=0; i<4; i++){
            for(int row=start; row<end; row++){
                for(int col=start; col<end; col++){          
                  for(int p=0; p<N; p++){
                      for(int q=0; q<N; q++)
                          tmp[p][q]=lock[p][q];
                  }
                    
                  for(int l=0; l<M; l++){
                      for(int s=0; s<M; s++){
                          if(row+l>=0 && row+l<N && col+s>=0 && col+s<N){
                              tmp[row+l][col+s] += Keys[i][l][s];
                          }
                      }
                    }
                    if(solved(tmp)) return true;
                }
            }        
        }
        
        return false;
    }
}
}
