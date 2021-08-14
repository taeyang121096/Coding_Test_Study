/*
2021 Dev-Matching:웹 백엔드 개발자(상반기) 다단계 칫솔 판매
*/
package kakao;
import java.util.*;
public class multilevel {
class Solution {
    
    int[] answer; 
    Map<String,Integer> map = new HashMap<>();
    public void Fee(String people, int fee, String[] enroll, String[] referral){
        if(fee==0) return;   
        
        int nextfee= (int)(fee*0.1);
        String nextpeople = referral[map.get(people)];
        
        if(!nextpeople.equals("-")){
            answer[map.get(nextpeople)]+=(fee-nextfee);
            Fee(nextpeople,nextfee,enroll,referral);
        }
        
    }
        
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
           
        answer = new int[enroll.length];      
        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i],i);
        }
        
        for(int i=0; i<seller.length; i++){
            
            String people = seller[i];
            int money = amount[i]*100;
            int fee = (int)(money*0.1);
            
            answer[map.get(people)] += (money-fee);
            Fee(people,fee,enroll,referral);
        }
            
        return answer;
    }
}
}
