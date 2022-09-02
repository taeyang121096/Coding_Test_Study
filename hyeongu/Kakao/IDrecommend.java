import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        // 1단계
        String str = new_id.toLowerCase();
        char last = ' ';
        // 2단계
        for(int i = 0; i<str.length(); i++){
            // 6단계
            if(sb.length() == 15){
                break;
            }
            char ch = str.charAt(i);
            if(ch >='a' && ch<='z'){
                sb.append(ch);
                last = ch;
            }
            else if(ch >= '0' && ch <= '9'){
                sb.append(ch);
                last = ch;
            }
            else if(ch == '-' || ch == '_'){
                sb.append(ch);
                last = ch;
            }
            else if(ch == '.'){
                //3단계, 4-1단계
                if(last != ch && sb.length()>0){
                    sb.append(ch);
                    last = ch;
                }
            }
        }
        //4-2단계        
        if(last == '.'){
            sb.setLength(sb.length()-1);
            last = sb.substring(sb.length()-1).charAt(0);
        }
        //5단계
        if(sb.length() == 0){
            sb.append('a');
            last = 'a';
        }
        //7단계
        while(sb.length()<=2){
            sb.append(last);
        }
        return sb.toString();
    }
}