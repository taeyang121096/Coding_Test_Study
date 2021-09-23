/**
 * 2020 KAKAO BLINDRECUITMENT 괄호 변환
 */
package kakao;

public class change_bracket {
  class Solution {
    public String solution(String p) {
        String answer = "";
        
        answer = split(p);  
        return answer;
    }
    
    public String split(String s){
        
        if(s.length()==0) return "";
        
        String str="";
        String u="", v="";
        int a=0,b=0;
        int end=0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(') a++;
            else b++;
            if(a==b) {
                end=i;
                break;
            }
        }
        
        for(int i=0; i<=end; i++){
            u+=s.charAt(i);
        }
        for(int i=end+1; i<s.length(); i++){
            v+=s.charAt(i);
        }
        
        if(right(u)){
            str+=u;
            str+=split(v);
        }else{
            str+="(";
            str+=split(v);
            str+=")";
            String tmp="";
            for(int i=1; i<u.length()-1; i++){
                char c = u.charAt(i);
                if(c=='(') tmp+=")";
                else tmp+="(";
            }
            str+=tmp;
        }
        return str;
    }    
    public boolean right(String s){
        char[] stack= new char[s.length()];
        int index=0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(') stack[index++]='(';
            else{
                if(index==0) return false;        
            }
        }
        return true;
    }  
}
}
