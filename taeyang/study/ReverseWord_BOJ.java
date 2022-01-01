import java.util.*;
import java.io.*;
public class ReverseWord_BOJ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(char c : br.readLine().toCharArray()){
            if('a'<=c && c<='z')
                stack.push(c);
            else if(c==' '){
                if(stack.contains('<'))
                    stack.push(c);
                else{
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                }

            }else if(c == '<' || c== '>'){

                if(c == '<'){
                    if(!stack.isEmpty()){
                        while(!stack.isEmpty()){
                            sb.append(stack.pop());
                        }
                    }
                    stack.push(c);
                }

                else{
                    while(!stack.isEmpty()){
                        sb.append(stack.pollLast());
                    }
                    sb.append(c);
                }

            }else{
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
