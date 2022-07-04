// 
import java.util.*;

class Solution {
    public int count = 0;//이진변환 횟수
    public int remove = 0;//제거한 0의 갯수
    
    public void translation(String s){
        int len = 0;
        count++;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                len++;
            }
            else{
                remove++;
            }
        }
        if(len==1)
            return;

        translation(Integer.toString(len,2));
        
    }
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        translation(s);
        
        answer[0] = count;
        answer[1] = remove;
        
        return answer;
    }
}