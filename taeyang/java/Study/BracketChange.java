import java.util.*;
public class BracketChange {

    class Solution {
        Deque<Character> stack = new ArrayDeque<>();

        String[] split(String p){
            String[] res = new String[2];
            if(p.equals("")){
                res[0] = "";
                res[1] = "";
                return res;
            }
            stack.push(p.charAt(0));

            int index = 1;
            for(int i =1;i<p.length();i++){
                if(stack.peek() == p.charAt(i))
                    stack.push(p.charAt(i));
                else
                    stack.pop();
                if(stack.isEmpty()){
                    index = i;
                    break;
                }
            }

            res[0] = p.substring(0,index+1);
            if(index+1 == p.length())
                res[1] = "";
            else
                res[1] = p.substring(index+1);
            stack.clear();
            return res;
        }

        boolean checkString(String s){
            if(s.charAt(0) == ')')
                return false;
            stack.push(s.charAt(0));
            for(int i = 1;i<s.length();i++){
                if(stack.isEmpty()){
                    return false;
                }
                if(s.charAt(i) == ')')
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }
            return true;
        }

        String change(String s){
            String res="";
            if(s.length() == 2)
                return res;
            else{
                for(int i = 1;i<s.length()-1;i++){
                    if(s.charAt(i) == '(')
                        res += ")";
                    else
                        res += "(";
                }
            }
            return res;
        }

        String make(String p,String ans){
            String u = split(p)[0];
            String v = split(p)[1];
            if(u.equals(""))
                return ans;

            if(checkString(u)){
                ans += u;
                ans += make(v,"");
            }else{
                String tmp ="";
                tmp += "(";
                tmp += make(v,"");
                tmp += ")";
                tmp += change(u);
                ans += tmp;
            }
            return ans;
        }

        public String solution(String p) {
            String answer = "";
            if(p.equals(""))
                return p;
            answer += make(p,"");
            return answer;
        }
    }
}
