import java.util.*;
public class ZipDecode {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] ch = str.toCharArray();
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        String ans = "";
        boolean flag = false;
        int count = 0;
        for(int i = 0;i<ch.length;i++){
            if(ch[i] == '('){
                count++;
                if(flag)
                    continue;
                String st = sb.toString();
                if(st.charAt(st.length()-1) == '0'){
                    stack.clear();
                    flag= true;
                    continue;
                }
                stack.push(sb.toString());
                sb.setLength(0);
                continue;
            }
            if(ch[i] == ')'){
                count--;
                if(count == 0) {
                    flag = false;
                    sb.setLength(0);
                }
                if(stack.isEmpty())
                    continue;
                String val = stack.pop();
                int num = Character.getNumericValue(val.charAt(val.length()-1));
                val = val.substring(0,val.length()-1);
                String tmp = ans+sb.toString();
                ans = tmp.repeat(num);
                ans = val+ans;
                sb.setLength(0);
                continue;
            }
            sb.append(ch[i]);
        }
        ans += sb.toString();
        System.out.println(ans.length());
    }
}
