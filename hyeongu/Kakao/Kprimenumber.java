import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while(n!=0){      
            sb.insert(0, n%k);
            n/=k;
        }

        String[] arr = sb.toString().split("0");
        
        for(String str: arr){
            if(str.equals("")){
                continue;
            }
            long num=Long.parseLong(str);
            
            if(prime(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean prime (long num){
        
        if(num < 2){
           return false; 
        } 
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}