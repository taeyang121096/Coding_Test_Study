package Programmers;

import java.util.*;

public class Tuple {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}"	;
        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] split = s.split(",");
        for(int i = 0; i < split.length; i++){
            if(map.containsKey(split[i])){
                map.put(split[i], map.get(split[i]) + 1);
            } else {
                map.put(split[i], 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int[] answer = new int[map.size()];

        int i = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            answer[i] = Integer.parseInt(entry.getKey());
            i++;
        }

        for(int j = 0; j < answer.length; j++){
            System.out.println(answer[j]);
        }
    }
}
