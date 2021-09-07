/**
 * 2020 KAKAO BLIND RECRUITMENT 기둥과 보 설치
 */
package kakao;

public class pillar { 
class Solution {
   
    boolean[][] bo;
    boolean[][] gi;
    
    boolean checkgi(int x, int y){
        // 밑에 기둥이 있는 경우 or 맨 밑에 기둥을 설치하는 경우
        if(y==0 || gi[x][y-1]) return true;
        // 아래 보가 존재하는 경우
        if( (x>0&& bo[x-1][y]) || bo[x][y]) return true;
         
        return false;
    }
    boolean checkbo(int x, int y){
        // 밑에 기둥이 존재하는 경우
        if(gi[x][y-1] || (x < gi.length-1 && gi[x+1][y-1] )) return true;
        // 양 옆에 보가 있는 경우
        if( (x>0 && bo[x-1][y]) && (x<bo.length-1 && bo[x+1][y] )) return true;
        
        return false;
    }
    
    boolean delete(int x, int y){
        for(int i = Math.max(x-1, 0); i<= x+1;i++){
            for(int j=y; j<=y+1; j++){
                if(bo[i][j] && !checkbo(i,j)){
                    return false;
                }
                if(gi[i][j] && !checkgi(i,j)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        
        bo= new boolean[n+1][n+1];
        gi= new boolean[n+1][n+1];
        
        int count=0;
        for(int[] input : build_frame){
            //x,y 좌표,  a=0 기둥 a=1 보, b=0 삭제 b=1 설치
            int x=input[0];
            int y=input[1];
            int a=input[2];   
            int b=input[3];
            
            if(b==1){
                if(a==0){
                    if(checkgi(x,y)){
                        gi[x][y]=true;
                        count++;    
                    }
                }else{
                    if(checkbo(x,y)){
                        bo[x][y]=true;
                        count++;
                    }
                }
            }else{
                if(a==0){
                    gi[x][y]=false;
                    if(!delete(x,y)){
                        gi[x][y]=true;
                    }else{
                        count--;
                    }
                    
                }else{
                    bo[x][y]=false;
                    if(!delete(x,y)){
                        bo[x][y]=true;
                    }else{
                        count--;
                    }
                }
            }
        }
     
        int[][] answer=new int[count][3];
        count =0;
        
        for(int x=0; x<=n; x++){
            for(int y=0; y<=n; y++){
                if(gi[x][y]){
                    answer[count][0]=x;
                    answer[count][1]=y;
                    answer[count++][2]=0;
                }
                if(bo[x][y]){
                    answer[count][0]=x;
                    answer[count][1]=y;
                    answer[count++][2]=1;
                }
            }
        }
        
        return answer;
    }
}
}
