import java.util.*;
public class DartGame {
    class Solution {
        public int solution(String dartResult) {

            Stack<Integer> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
//         charcter -> 별로 계산을 하기 위한 반복문
            for(char res : dartResult.toCharArray()){
                if(Character.isDigit(res)){
                    sb.append(res);
                }else if(Character.isLetter(res)){
                    int val = Integer.parseInt(sb.toString());
                    if(res == 'S'){
                        stack.push((int)Math.pow(val,1));
                    }else if(res == 'D'){
                        stack.push((int)Math.pow(val,2));
                    }else{
                        stack.push((int)Math.pow(val,3));
                    }
//                 builder 초기화
                    sb.setLength(0);
                }else{
                    if(res == '*'){
                        if(stack.size()>=2){
                            int val2 = stack.pop() * 2;
                            int val1 = stack.pop() * 2;
                            stack.push(val1);
                            stack.push(val2);
                        }else{
                            int val = stack.pop() * 2;
                            stack.push(val);
                        }
                    }else{
                        int val = stack.pop() * -1;
                        stack.push(val);
                    }
                }
            }


//         더하기 계산
            return stack.stream().mapToInt(Integer::intValue).sum();
        }
    }
}
