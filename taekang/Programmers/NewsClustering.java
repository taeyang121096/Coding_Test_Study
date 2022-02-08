package Programmers;

import java.util.*;

public class NewsClustering {
    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";

        // 대문자와 소문자의 차이는 무시한다.
        String s1 = str1.toUpperCase();
        String s2 = str2.toUpperCase();

        HashMap<String, Integer> map1 = Cluster(s1);
        HashMap<String, Integer> map2 = Cluster(s2);

        int count = 0;
        int inter = 0;
        int union = 0;
        for (String key : map1.keySet()) {
            for (String key2 : map2.keySet()) {
                if (key.equals(key2)) {
                    int min = Math.min(map1.get(key), map2.get(key2));
                    int max = Math.max(map1.get(key), map2.get(key2)); // key와 key2가 같으면 max를 구해서 길이에 더해준다 ?
                    union += max;
                    inter += min;
                    count ++ ;
                }
            }
        }
        double answer1 = (double) inter / (double) (union + map1.size() - count + map2.size() - count) * 65536;
        int answer = (int)Math.floor(answer1);
        if(answer == 0){
            System.out.println(65536);
        } else {
            System.out.println(answer);
        }
    }

    public static HashMap<String, Integer> Cluster(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90 && s.charAt(i + 1) >= 65 && s.charAt(i + 1) <= 90) {
                String tmp = Character.toString(s.charAt((i))) + Character.toString(s.charAt(i + 1));
                if(!map.containsKey(tmp)) {
                    map.put(tmp, 1);
                } else {
                    map.put(tmp, map.get(tmp) + 1);
                }
            }
        }
        return map;
    }
}
