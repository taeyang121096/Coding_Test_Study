/**
 * 2021 KAKAO 채용연계형 인턴십 카드 짝 맞추기
 */
package kakao;
public class editTable{
    class Solution {
        int[] stack;    
        int stacksize=0;
        
        public String solution(int n, int k, String[] cmd) {
                    
            stack = new int[n];   
            int point=k;
            int max=n-1;
        
            for(String str : cmd){
                String[] token = str.split(" ");
                if(token[0].equals("D")){
                    int tmp = Integer.parseInt(token[1]);
                    point += tmp;
                }else if(token[0].equals("U")){
                    int tmp = Integer.parseInt(token[1]);
                    point -= tmp;
                }else if(token[0].equals("C")){     
                    stack[stacksize++]=point;
                    if(point == max ) point--;
                    max--;
                }else{
                    int tmp=stack[--stacksize];
                    if(tmp<=point) point++;
                    max++;
                }
            }
                        
            StringBuilder sb= new StringBuilder();
            
            for(int i=0; i<=max; i++)
                sb.append("O");
            while(stacksize>0){
                sb.insert(stack[--stacksize],"X");
            }
            
            return sb.toString();
        }
    }
}