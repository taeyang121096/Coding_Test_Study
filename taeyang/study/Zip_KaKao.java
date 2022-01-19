import java.util.*;

public class Zip_KaKao {


    public int solution(String s) {

        Stack<String> stack = new Stack<>();
        int len = Integer.MAX_VALUE;
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

