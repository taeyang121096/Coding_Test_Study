import java.util.*;
class Solution {
    /*
    1. substring 1 ~ n/2
    2. stack -> push
    3. 다르면 -> sb.append()
    */
    public int solution(String s) {
        int answer = 1000;
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        if(s.length() == 1)
            return 1;

        for(int i = 1;i<=s.length()/2;i++){
            for(int j = 0;j<s.length();j += i){
                String str;
                if(j+i >= s.length()){
                    str = s.substring(j);
                }else{
                    str = s.substring(j,j+i);
                }

                if(stack.isEmpty()){
                    stack.push(str);
                }else{
                    if(stack.peek().equals(str)){
                        stack.push(str);
                    }else{
                        if(stack.size() == 1 ){
                            sb.append(stack.pop());
                        }else{
                            sb.append(String.valueOf(stack.size())+stack.pop());
                        }
                        stack.clear();
                        stack.push(str);
                    }
                }
            }
            if(!stack.isEmpty()){
                if(stack.size() != 1){
                    sb.append(String.valueOf(stack.size())+stack.pop());
                }else{
                    sb.append(stack.pop());
                }
                stack.clear();
            }
            answer = Math.min(answer,sb.length());
            sb.setLength(0);
        }



        return answer;
    }
}