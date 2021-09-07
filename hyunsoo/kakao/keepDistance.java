/**
 * 2021 KAKAO 채용연계형 인턴십 카드 짝 맞추기
 */
package kakao;

public class keepDistance {
  class Solution {
    String[][] Places;
    
    public boolean search(int idx, int x, int y,int mode){
        //mode=1 아래 탐색
        //mode=0 오른쪽 탐색
        //mode=2 왼쪽탐색
        if(Places[idx][x].charAt(y)=='P') return true;
        
        if(mode==0){
            if(x+1<5 && Places[idx][x+1].charAt(y)=='P') return true;
            if(y+1<5 && Places[idx][x].charAt(y+1)=='P') return true;
        }else if(mode==1){
            if(x+1<5 && Places[idx][x+1].charAt(y)=='P') return true;
            if(y+1<5 && Places[idx][x].charAt(y+1)=='P') return true;
            if(y-1>=0 && Places[idx][x].charAt(y-1)=='P') return true;
        }else{
            if(x+1<5 && Places[idx][x+1].charAt(y)=='P') return true;
            if(y-1>=0 && Places[idx][x].charAt(y-1)=='P') return true;
        }
        
        return false;
    }    
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};        
        Places=places;

        for(int i=0; i<5; i++){
            boolean check=false;
            for(int l=0; l<5; l++){
                for(int m=0; m<5; m++){
                    if(!check && places[i][l].charAt(m)=='P' ) {
                        if(m+1<5 && (places[i][l].charAt(m+1)=='O' || places[i][l].charAt(m+1)=='P')){ 
                           check=search(i,l,m+1,0);
                           if(check) {
                               answer[i]=0;
                               break;
                           } 
                        }
                        if(l+1<5 && (places[i][l+1].charAt(m)=='O' || places[i][l+1].charAt(m)=='P')){ 
                            check=search(i,l+1,m,1);
                            if(check){ 
                                answer[i]=0;
                                break;
                            }
                        }
                        if(m-1>=0 && (places[i][l].charAt(m-1)=='O' || places[i][l].charAt(m-1)=='P')){ 
                            check=search(i,l,m-1,2);
                            if(check){ 
                                answer[i]=0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
}
