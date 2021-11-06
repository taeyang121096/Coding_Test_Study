package basic;
import java.util.*;
public class PostPre {

    public static void main(String[]args){
        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('+',0);
        map.put('-',0);
        map.put('*',1);
        map.put('/',1);
        map.put('(',-1);
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        String ans = "";
        int start = 'A';
        int end = 'Z';
        for(char c : exp.toCharArray()){
            if(c<start || c>end){
                if(stack.isEmpty()){
                    stack.push(c);
                }
                else{
                    if(c==')'){
                        while(stack.peek() != '('){
                            ans+= stack.pop();
                        }
                        stack.pop();
                    }else if(c=='('){
                        stack.push('(');
                    }
                    else{
                        if(map.get(stack.peek()) >= map.get(c)){
                            while(!stack.isEmpty()){
                                if(stack.peek()  == '(')
                                    break;
                                ans += stack.pop();
                            }
                            stack.push(c);
                        }else{
                            stack.push(c);
                        }
                    }

                }
                continue;
            }
            ans += c;
        }
        while(!stack.isEmpty()){
            ans += stack.pop();
        }

        System.out.println(ans);
    }
}
