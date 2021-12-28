package basic;
import java.util.*;
import java.io.*;
public class Reverse2 {
    static Deque<Character> q = new ArrayDeque<>();
    static Deque<Character> stack = new ArrayDeque<>();
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i = 0;i<str.length();i++) {
            if(str.charAt(i) == '<'){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                q.offer('<');
                flag = true;
                continue;
            }
            if(str.charAt(i) =='>'){
                q.offer('>');
                while(!q.isEmpty()){
                    sb.append(q.poll());
                }
                flag = false;
                continue;
            }
            if(flag) {
                q.offer(str.charAt(i));
                continue;
            }
            if(str.charAt(i) == ' '){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(' ');
                continue;
            }
            stack.push(str.charAt(i));
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());


    }

}
