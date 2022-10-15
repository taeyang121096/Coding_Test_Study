package Programmers.lv3;

import java.io.*;
import java.util.*;

public class DiaShopping {
    public static Map<String, Integer> map = new HashMap<>();
    public static Map<String, Integer> dia_map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int[] answer = {};
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};

        for (int i = 0; i < gems.length; i++) {
            if (!map.containsKey(gems[i])) {
                map.put(gems[i], 1);
            } else {
                map.put(gems[i], map.get(gems[i]) + 1);
            }
        }
//        for (String key : map.keySet()) {
//            System.out.println(key + " " + map.get(key));
//        }
        if(map.size() == 1){
            answer = new int[]{1, 1};
            System.out.println(answer[0] + " " + answer[1]);
            System.exit(0);
        }

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        dia_map.put(gems[0], 1);

        for (int i = 1; i < gems.length; i++) {
            // 일단 map에 넣는데
            // i = 5
            // start = 3
            // {dia, 2} {ruby, 1} {emerald ,1}
            if (!dia_map.containsKey(gems[i])) {
                dia_map.put(gems[i], 1);
            } else {
                dia_map.put(gems[i], dia_map.get(gems[i]) + 1);
            }
            // start 인덱스를 map에서 찾아서 빼도 size가 줄어드는게 아니면, start++;
            // 만약 줄어들면 start는 그대로,
            if (dia_map.size() == map.size()) {
                // 시작 idx
                int k = i - start;
                if (min > k) {
                    min = k;
                    answer = new int[]{start + 1, i + 1};
                }
                // 여기서 부턴 i 고정해놓고 i가 추가되었을때 앞에거 삭제해가면서 가장 짧은 길이를 구할 수 있다면 그것을 답으로 채택함
                int j = start; // 시작은 start부터
                while(true){
                    // 만약 dia_map 속에 보석이 1개보다 많다면 하나씩 삭제하고 start 지점을 늘려가도록 함
                    if(dia_map.get(gems[j]) > 1){
                        dia_map.put(gems[j], dia_map.get(gems[j]) - 1); //
                        start++;
                        j++;
                    } else if(dia_map.get(gems[j]) == 1){ // 만약 한개이면 줄이는 순간 map.size() 보다 작아지므로 종료함.
                        int k2 = i - start;
                        if (min > k2) {
                            min = k2;
                            answer = new int[]{start + 1, i + 1};
                        }
                        break;
                    }
                    // 시간줄이려고 했는데 별 의미없는듯 함
                    if(j == i){
                        break;
                    }
                }
                // 끝 idx -> i
            } else if (dia_map.size() < map.size()) {
                if (dia_map.get(gems[start]) == 1) { // 이상태면 start를 유지해야 겠지 ?
                    continue;
                } else if (dia_map.get(gems[start]) > 1) { // 만약
                    dia_map.put(gems[start], dia_map.get(gems[start]) - 1); //
                    start++; // 1
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}