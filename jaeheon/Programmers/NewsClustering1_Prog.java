import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        int union = 0;
        int inter = 0;
        HashMap<String, Integer> hm1 = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();
        
        for(int i = 0; i < str1.length() - 1; i++){
            String s1 = str1.substring(i, i + 2).replaceAll("[^A-Z]", "");
            if(s1.length() < 2){
                continue;
            }
            hm1.put(s1, hm1.getOrDefault(s1, 0) + 1);
        }
        
        for(int i = 0; i < str2.length() - 1; i++){
            String s2 = str2.substring(i, i + 2).replaceAll("[^A-Z]", "");
            if(s2.length() < 2){
                continue;
            }
            hm2.put(s2, hm2.getOrDefault(s2, 0) + 1);
        }
        
        if(hm1.size()  == 0 && hm2.size() == 0){
            return 65536;
        }

        for(String key : hm1.keySet()){
            if(hm2.containsKey(key)){
                inter+=Math.min(hm1.get(key), hm2.get(key));
                union+=Math.max(hm1.get(key), hm2.get(key));
                hm2.remove(key);
            } else{
                union += hm1.get(key);
            }
        }
        for(String key1 : hm2.keySet()){
            union += hm2.get(key1);
        }
        
        answer = (int)Math.floor(((double)inter/(double)union) * 65536);
        

        return answer;
        
    }
}