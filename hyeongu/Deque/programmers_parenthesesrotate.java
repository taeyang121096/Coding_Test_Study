import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for(int i = 0; i<s.length(); i++){
            Deque<Character> q = new ArrayDeque<>();
            for(int j = 0; j<s.length(); j++){
                q.offer(s.charAt(j));
            }
            for(int k = 0; k < i; k++){
                q.offerLast(q.poll());
            }
            if(check(q)){
                answer++;
            }
        }

        return answer; 
    }
    public boolean check(Deque<Character> q) {
       Stack<Character> stack = new Stack<>();
        while(!q.isEmpty()){
            switch(q.peek()){
                case '[':
                case '{':
                case '(':
                    stack.push(q.poll());
                    break;
                case ']':
                    if(!stack.isEmpty()){
                        if(stack.peek() == '['){
                            stack.pop();
                            q.poll();
                            break;
                        }
                    }
                    return false;
                case '}':
                    if(!stack.isEmpty()){
                        if(stack.peek() == '{'){
                            stack.pop();
                            q.poll();
                            break;
                        }
                    }
                    return false;
                case ')':
                    if(!stack.isEmpty()){
                        if(stack.peek() == '('){
                            stack.pop();
                            q.poll();
                            break;
                        }
                    }
                    return false;
                }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}