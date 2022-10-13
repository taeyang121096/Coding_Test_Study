import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int count = 0;
        for(String str : quiz){
            StringTokenizer st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            String symbol = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            st.nextToken();
            int c = Integer.parseInt(st.nextToken());
            
            switch(symbol){
                case "+":
                    if(c == a+b){
                        answer[count++] = "O";
                    }
                    else{
                        answer[count++] = "X";
                    }
                    break;
                case "-":
                    if(c == a-b){
                        answer[count++] = "O";
                    }
                    else{
                        answer[count++] = "X";
                    }
                    break;
            }
        }
        return answer;
    }
}