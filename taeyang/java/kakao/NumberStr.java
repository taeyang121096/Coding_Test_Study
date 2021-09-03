import java.util.*;
class Solution {
    static Map<String, String> map = new HashMap<>();
    public int solution(String s) {
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");


        int answer = 0;
        String ans = "";
        String tmp ="";
        for(char c : s.toCharArray()){
            if(Character.isDigit(c))
                ans += Character.toString(c);
            else{
                tmp += c;
                if(map.containsKey(tmp)){
                    ans += map.get(tmp);
                    tmp = "";
                }
            }
        }
        answer = Integer.parseInt(ans);
        return answer;
    }
}