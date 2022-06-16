import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    public String solution(String p) {
        String answer = separate(p);   
        return answer;
    }
    
    public static String separate(String p){
        Queue<Character> queue = new LinkedList<>();
        StringBuilder u = new StringBuilder();
        
        if(p.length()==0)
            return p;
        
        for(int i= 0; i<p.length(); i++){
            if(queue.isEmpty() || queue.peek().equals(p.charAt(i))){
                queue.offer(p.charAt(i));
                u.append(p.charAt(i));
            }
            else{
                queue.poll();
                u.append(p.charAt(i));
                if(queue.isEmpty()){
                    if(i<p.length()-1)
                        return makeRight(u.toString(), separate(p.substring(i+1)));
                    else
                        return makeRight(u.toString(), "");
                }
            }
        }
        return p;
    }
    
    public static String makeRight(String u, String v){      
        StringBuilder combine = new StringBuilder();
        
        if(u.charAt(0)=='('){
            combine.append(u);
            combine.append(v);
        }
        else{
            combine.append('(');
            combine.append(v);
            combine.append(')');

            for(int i=1; i<u.length()-1;i++){
                if(u.charAt(i)=='(')
                    combine.append(')');
                else
                    combine.append('(');
            }
        }   
        return combine.toString();
    }
}