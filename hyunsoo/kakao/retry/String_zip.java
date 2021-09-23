package kakao.retry;
import java.util.*;
public class String_zip { 
class Solution {
    public int solution(String s) {
        
        int answer = s.length();
        
        for(int i=1; i<=s.length()/2; i++){
            String laststr = s.substring(0,i);    
            int tmp = s.length();
            int compress=1;
            for(int j=i; j+i<=s.length(); j+=i){
                String nowstr=s.substring(j,j+i);
                if(laststr.equals(nowstr)) compress++;
                else{
                    if(compress!=1) {
                        
                        tmp= tmp-(compress-1)*i;
                        int leng=1;
                        while(compress/10>0){
                            compress=compress/10;
                            leng++;
                        }
                        tmp += leng;
                    }
                   
                    laststr=nowstr;
                    compress=1;
                }
            }
            
            if(compress!=1) {
                tmp= tmp-(compress-1)*i;
                int leng=1;
                while(compress/10>0){
                    compress=compress/10;
                    leng++;
                }
                tmp += leng;
            }           
            answer = Math.min(answer, tmp);
        }
               
        return answer;
    }
}
}
