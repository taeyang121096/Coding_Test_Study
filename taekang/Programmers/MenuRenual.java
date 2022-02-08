package Programmers;

import java.util.*;

public class MenuRenual {
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        ArrayList<String> list = new ArrayList<>();
        int[] course = {2, 3, 4};

        HashMap<String, Integer> map = new HashMap<>();
        String tmp = "";
        int i = 0;
        while (i < orders.length) {
            for (int j = 0; j < orders.length; j++) {
                for (int k = 0; k < orders[j].length(); k++) {
                    if (i != j && orders[i].contains(Character.toString(orders[j].charAt(k)))) {
                        tmp += orders[j].charAt(k);
                    }
                }
                if (tmp.length() == course[0] || tmp.length() == course[1] || tmp.length() == course[2]) {
                    if(map.containsKey(tmp)){
                        map.put(tmp, map.get(tmp) + 1);
                    } else {
                        map.put(tmp, 1);
                    }
                }
                tmp = "";
            }
            i++;
        }

        String[] answer = new String[map.size()];
        int m = 0;
        for(String key : map.keySet()){
            //if(map.get(key) >= 2){
                answer[m] = key;
                m++;
                System.out.println(map.get(key));
           // }
        }
        Arrays.sort(answer);
        for(int l = 0 ; l < map.size(); l ++){
            System.out.println(answer[l]);
        }
    }
}
