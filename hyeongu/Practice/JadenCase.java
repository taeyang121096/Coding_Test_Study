import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String tmp = s.toLowerCase();
        boolean flag = true;
        
        for(int i = 0; i<tmp.length(); i++){
            char c = tmp.charAt(i);
            if(!flag){
                if(c == ' '){
                    flag = true;
                    sb.append(c);
                }
                else{
                    sb.append(c);
                }
            }
            else{
                if(c == ' '){
                    sb.append(c);
                }
                else if(c>='0' && c<='9'){
                    sb.append(c);
                    flag = false;
                }
                else{
                    sb.append((char)(c - 32));
                    flag = false;
                }
            }
        }
        return sb.toString();
    }
}