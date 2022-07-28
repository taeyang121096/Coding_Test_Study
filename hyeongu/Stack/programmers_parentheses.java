import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Integer>stack = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(0);
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}