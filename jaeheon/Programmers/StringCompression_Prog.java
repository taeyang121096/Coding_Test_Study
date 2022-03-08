package Programmers;

//자르는 단위의 수가 절반을 넘어가면 압축이 되지 않음 
//ex) s = 9일때 자르는 단위가 5이면 불가능 -> 1, 2, 3, 4만 
//-> s.length()/2 -> 4.5까지
import java.util.*;

class StringCompression_Prog {
 
 public int solution(String s) {

     Stack<String> stack = new Stack<>();
     int len = Integer.MAX_VALUE; // 최대 구할 때 min, 최소 구할 때 max
     if (s.length() == 1)
         return 1;

     for (int i = 1; i <= s.length() / 2; i++) {
         StringBuilder sb = new StringBuilder();
         
         int start = -1;
         for (int j = 0; j < s.length(); j += i) {
             if (j + i > s.length()) {
                 start = j;
                 break;
             }
             
             String tmp = s.substring(j, j + i);

             if (stack.isEmpty()) {
                 stack.push(tmp);
             } else {
                 if (stack.peek().equals(tmp)) {
                     stack.push(tmp);
                 } else {
                     if (stack.size() == 1) {
                         sb.append(stack.pop());
                         stack.push(tmp);
                     } else {
                         sb.append(stack.size());
                         sb.append(stack.pop());
                         stack.clear();
                         stack.push(tmp);
                     }
                 }
             }
         }
         if (!stack.isEmpty()) {
             if (stack.size() == 1) {
                 sb.append(stack.pop());
             } else {
                 sb.append(stack.size());
                 sb.append(stack.pop());
                 stack.clear();
             }
         }
         if (start != -1) {
             sb.append(s.substring(start));
         }

         len = Math.min(sb.length(), len);
     }


     return len;
 }
}
