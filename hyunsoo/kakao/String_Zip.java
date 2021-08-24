/*
2020 KAKAO BLIND RECRUITMENT 문자열 압축
*/
package kakao;
public class String_Zip {
class Solution {
        
     public int solution(String s) {

        int answer = Integer.MAX_VALUE;     
               
        for(int i=1; i<=s.length()/2+1; i++){
            String substr = s.substring(0,0+i);
            int compre=0;
            int count=1;            
            for(int j=i; j<s.length(); j= j+i){
                if(j+i<=s.length()){
                    String sb = s.substring(j,j+i);
                    if(substr.equals(sb)) count++;
                    else{
                        if(count>1){
                            compre = compre + (i*(count-1));
                            int check=1;
                            while(count/10>0){ check++; count=count/10;}
                            compre -=check;
                            substr=s.substring(j,j+i);
                            count=1;
                        }
                        else{
                            substr=s.substring(j,j+i);
                        }
                    }
                }
                
            }
            if(count>1){
                compre = compre + (i*(count-1));
                int check=1;
                while(count/10>0){ check++; count=count/10;}
                compre -=check;
            }
            
            answer=Math.min(answer,s.length()-compre);
        }
        return answer;
    }
}
}
