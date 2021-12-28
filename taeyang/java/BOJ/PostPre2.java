package basic;

import java.util.*;
public class PostPre2 {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        Deque<Double> stack = new ArrayDeque<>();
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        int start = 'A';
        int end = 'Z';
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)>end || str.charAt(i)<start) {
                continue;
            }
            map.put(str.charAt(i),0);
        }
        for(char c : map.keySet()){
            int num = Integer.parseInt(sc.nextLine());
            map.put(c,num);
        }

        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)>end || str.charAt(i)<start) {
                double second = stack.pop();
                double first = stack.pop();
                double val = 0;
                if(str.charAt(i) == '*'){
                    val = first * second;
                }
                else if(str.charAt(i) == '/'){
                    val = first / second;
                }
                else if(str.charAt(i) == '-'){
                    val = first - second;
                }
                else if(str.charAt(i) == '+'){
                    val = first + second;
                }
                stack.push(val);
                continue;
            }
            stack.push((double)map.get(str.charAt(i)));
        }
        System.out.printf("%.2f",stack.pop());

    }
}
