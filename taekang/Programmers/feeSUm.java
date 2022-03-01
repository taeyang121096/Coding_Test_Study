package Programmers;
import java.util.*;
public class feeSUm {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN"
                , "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        HashMap<String, Boolean> isIn = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        // 5961 334
        for (int i = 0; i < records.length; i++) {
            String[] str = records[i].split(" "); // 05:34 5961 IN
            String[] s = str[0].split(":"); // 05 34
            int time = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            // 만약 IN이면 -time, 만약 OUT이면 +time
            // 만약 time = 1439 를 넘었는데 OUT이 안되면 23:59에 출차된 거로 간주 한다
            // 출차 입차를 boolean으로 ?;;
            if (map.containsKey(str[1])) { // 5961
                if (str[2].equals("IN")) {
                    map.put(str[1], map.get(str[1]) - time);
                    isIn.put(str[1], false);
                } else {
                    map.put(str[1], map.get(str[1]) + time);
                    isIn.put(str[1], true);
                }
            } else {
                map.put(str[1], -time);
                isIn.put(str[1], false);
            }
        }

        for (String key : isIn.keySet()) {
            if (isIn.get(key) == false) {
                map.put(key, map.get(key) + 1439);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) <= fees[0]) {
                map.put(key, fees[1]);
            } else {
                double k = fees[1] + Math.ceil((double) (map.get(key) - fees[0]) / fees[2]) * fees[3];
                map.put(key, (int) k);
            }
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int[] answer = new int[map.size()];
        int i = 0;
        for (String key : keys) {
            answer[i] = map.get(key);
            i++;
        }
//
//
//        System.out.println(map.size());
//        for(int i = 0 ; i < list.size(); i++){
//            answer[i] = list.get(i);
//        }
    }
}
