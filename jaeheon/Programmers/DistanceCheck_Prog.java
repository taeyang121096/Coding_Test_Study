package Programmers;
// 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
// 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
// 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
  // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
// 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
  // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
  // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
  // 4-3. ')'를 다시 붙입니다. 
  // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
  // 4-5. 생성된 문자열을 반환합니다.


// ( , ) 두개 개수가 같아지면 idx까지 문자열을 u로 하고 나머지를 v로
// 앞뒤로 문자열 잘라야 하니까 +1해주는거

import java.util.*;

class Distancecheck_Prog {
    
    static int idx = 0;
    
    static boolean divide(String p){
        boolean isChecked  = true;
        int left = 0;
        int right = 0;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            if(c == '('){
                stack.push('(');
                left++;
            } else{
                right++;
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                } else {
                    stack.push(')');
                    isChecked = false;
                }
            }
            if(left == right){
                idx = i + 1; // 앞뒤로 문자열 잘라야하니까  + 1
                break;
            }
        }
        return isChecked;
    }
    
    public String solution(String p) {
        StringBuilder sb = new StringBuilder();
        
        String answer = "";
        
        // 1
        if(p.equals("")){
            return p;
        }
        // 2
        boolean isChecked = divide(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx);
        
        // 3
        if(isChecked){
            return u + solution(v);
        }
        
        // 4
        sb.append("("); // 4-1
        sb.append(solution(v)); // 4-2
        sb.append(")"); // 4-3
        
        // 4-4
        for(int i = 1; i < u.length() - 1; i++){
            if(u.charAt(i) == '('){
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        
        //4-5
        return sb.toString();

    }
}