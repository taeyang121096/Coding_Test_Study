import java.util.*;
public class Location_Pro {

    class Solution {
        //     s길이 만큼 넘기면 된다.
//
        public int solution(String s) {
            int answer = 0;

            Deque<Character> q = new ArrayDeque<>();
            for(char c : s.toCharArray()){
                q.offer(c);
            }
            for(int i = 0;i<s.length();i++){
                q.offer(q.pollFirst());
                Stack<Character> stack = new Stack<>();
                boolean flag = false;
                for(char c : q){
                    if(c == '(' || c == '{' || c == '['){
                        stack.push(c);
                        continue;
                    }else{
                        if(stack.isEmpty()){
                            flag = true;
                            break;
                        }else{
                            if(c==')' && stack.peek() == '(')
                                stack.pop();
                            else if(c==']' && stack.peek() == '[')
                                stack.pop();
                            else if(c=='}' && stack.peek() == '{')
                                stack.pop();
                            else{
                                flag = true;
                                break;
                            }
                        }
                    }
                }
                if(!flag && stack.isEmpty())
                    answer++;
            }

            return answer;
        }
    }
}
