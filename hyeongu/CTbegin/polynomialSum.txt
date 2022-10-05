import java.util.*;

class Solution {
    public String solution(String polynomial) {
        StringTokenizer st = new StringTokenizer(polynomial, " + ");
        StringBuilder sb = new StringBuilder();
        int x_num = 0;
        int num = 0;
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            if(str.charAt(str.length() - 1) == 'x'){
                if(str.length() == 1){
                    x_num++;
                }
                else{
                    x_num += Integer.parseInt(str.substring(0, str.length() - 1));
                }
            }
            else{
                num += Integer.parseInt(str);
            }
        }
        
        if(x_num > 1){
            sb.append(x_num).append("x");
        }
        if(x_num == 1){
            sb.append("x");
        }
        if(x_num > 0 && num > 0){
            sb.append(" + ");
        }
        if(num > 0){
            sb.append(num);
        }
        
        return sb.toString();
    }
}