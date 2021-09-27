package kakao.retry;

public class pillar {
  class Solution {
    
    int[][] board;
    boolean[][] bo;
    boolean[][] gi;
    
    public boolean checkgi(int x, int y){
        if(y==0) return true;
        if( (x>0 && bo[x-1][y]) || gi[x][y-1] || (x<gi.length && bo[x][y])) return true;
    
        return false;
    }
    public boolean checkbo(int x, int y){        
        if(gi[x][y-1]  || (x<bo.length && gi[x+1][y-1]) || (x>0 && x<bo.length-1 && bo[x-1][y] && bo[x+1][y])){
            return true;
        }
        return false;
    }
    
    public boolean deletegi(int x, int y){
        
        if(y+1<gi.length &&gi[x][y+1]){
            if(!checkgi(x,y+1)) return false;
        }
        if(x>0 && y+1<gi.length && bo[x-1][y+1]){
            if(!checkbo(x-1,y+1)) return false;
        }
        if( y+1<gi.length && bo[x][y+1]){
            if(!checkbo(x,y+1)) return false;
        }
        
        return true;
    }
    
    public boolean deletebo(int x, int y){
        
        if(gi[x][y]){
            if(!checkgi(x,y)) return false;    
        }
        if(x+1<gi.length && gi[x+1][y]){
            if(!checkgi(x+1,y)) return false;   
        }
        if(x>0 && bo[x-1][y]){
            if(!checkbo(x-1,y)) return false;
        }
        if(x+1 < gi.length && bo[x+1][y]){
            if(!checkbo(x+1,y)) return false;
        }
               
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        
        board=new int[n+1][n+1];
        bo=new boolean[n+1][n+1];
        gi=new boolean[n+1][n+1];
        
        int count=0;
        
        for(int i=0; i<build_frame.length; i++){
            
            int x= build_frame[i][0];
            int y= build_frame[i][1];
            int a= build_frame[i][2];
            int b= build_frame[i][3];
            
            if(b==0){  // 삭제
                if(a==0){ // 기둥
                    gi[x][y]=false;
                    count--;
                    if(!deletegi(x,y)) {gi[x][y]=true; count++;}
                }else{ // 보
                    bo[x][y]=false;
                    count--;
                    if(!deletebo(x,y)){ bo[x][y]=true; count++; }
                }
            }else{ // 설치
                if(a==0){ // 기둥
                    if(checkgi(x,y)){
                        gi[x][y]=true;
                        count++;
                    }
                }else{ // 보
                    if(checkbo(x,y)){
                        bo[x][y]=true;
                        count++;
                    }
                }
            }
                            
        }
        int[][] answer= new int[count][3];
        
        int index=0;
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(gi[i][j]){
                    answer[index][0]=i;
                    answer[index][1]=j;
                    answer[index++][2]=0;
                }
             
                if(bo[i][j]){
                    answer[index][0]=i;
                    answer[index][1]=j;
                    answer[index++][2]=1;
                }
            }
        }
        return answer;
    }
}
}
