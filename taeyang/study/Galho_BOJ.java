import java.util.*;
import java.io.*;
public class Galho_BOJ {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
//        4 3 6 8 7 5 2 1
//        + + + + - - + + - + + - - - - -
//        1 2 1초 : 1억이거든요
        Stack<Integer> stack = new Stack<>();

        int index = 1;

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<t;i++){
            int val = Integer.parseInt(br.readLine());
            while(index <=val){
                stack.push(index++);
                sb.append("+\n");
            }
            if(val == stack.peek()) {
                stack.pop();
                sb.append("-\n");
            }else{
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());


    }
}
