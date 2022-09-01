import java.util.*;

class Solution{
    public int solution(String s){
        int answer = 0;
        int left, right;
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1)){
                return 2;
            }
            else{return 1;}
        }
        
        for(int i = 1; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                left = i-1;
                right = i+2;
                answer = Math.max(answer, palindrome(left, right, s, 2));
            }
            left = i-1;
            right = i+1;
            answer = Math.max(answer, palindrome(left, right, s, 1));            
        }
        return answer;
    }
    
    public int palindrome(int left, int right, String s, int length){
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                length += 2;
                left--;
                right++;
            }
            else{
                return length;
            }
        }
        return length;
    }
}