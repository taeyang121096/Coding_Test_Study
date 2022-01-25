import java.util.*;
class MaxOperation_Prog {
    static char operator[] = {'+','-','*'};
    static long answer = 0;
    static boolean visit[] = new boolean[3];
    static ArrayList<Long> arr = new ArrayList<>();
    static ArrayList<Character> opList = new ArrayList<>();
    
    
    public static long solution(String expression) {
        answer = 0;
        
        String num ="";
        for(int i=0; i<expression.length(); i++) {
                if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    num += expression.charAt(i);
                }else {
                    arr.add(Long.parseLong(num));
                    num = "";
                    opList.add(expression.charAt(i));
                }
        }
        arr.add(Long.parseLong(num));
        
        dfs();
        
        return answer;
    }
    
    public static void dfs(){
        
    }
}