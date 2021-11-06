package BOJ.code_plus;
import java.util.*;
public class _1918 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    String answer = "";
    Stack<String> stack = new Stack<>();

    for(int i=0; i<str.length(); i++){
      char c = str.charAt(i);

      if(c=='('){
        stack.push("(");
        continue;
      }  
      if(c==')'){
        while(!stack.peek().equals("(")){
          answer += stack.pop();
        }
        stack.pop();
        continue;
      }
      
      if(c=='+' || c=='-'){
        if(stack.size()==0 || stack.peek().equals("(")){
          stack.push(String.valueOf(c));
        }else{
          while(stack.size()>0 && !stack.peek().equals("(")){
            answer += stack.pop();
          }
          stack.push(String.valueOf(c));
        }
        continue;
      }

      if(c=='*' || c=='/'){
        if(stack.size()>0 && (stack.peek().equals("*") || stack.peek().equals("/")) ){
          while(stack.size()>0 && !stack.peek().equals("(") && (stack.peek().equals("*") || stack.peek().equals("/")) ){
            answer += stack.pop();
          }
          stack.push(String.valueOf(c));
        }else{
          stack.push(String.valueOf(c));
        }
        continue;
      }
      
      answer += c;
    }

    while(stack.size()>0){
      if(stack.peek().equals("(")){stack.pop(); continue;}

      answer += stack.pop();
    }

    System.out.println(answer);
  }
}
