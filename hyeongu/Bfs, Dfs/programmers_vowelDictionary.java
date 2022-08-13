import java.util.*;

class Solution {
    static String[] arr = {"A", "E", "I", "O", "U"};
    static Map<String, Integer> hm = new HashMap<>();
    static int count = 0;
    public int solution(String word) {
        
        String str = "";
        dfs(str);
        int answer = hm.get(word);
        
        return answer;
    }
    
    static void dfs(String str){
        hm.put(str, count++);
        
        for(int i = 0; i< 5 ; i++){
            if(str.length()<5){
                dfs(str + arr[i]);
            }
            else{
                return;
            }
        }
    }
}