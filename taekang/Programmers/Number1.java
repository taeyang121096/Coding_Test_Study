package Programmers;

import java.util.*;

public class Number1 {
    public static void main(String[] args) {
        {
            String[] participant = {"mislav", "stanko", "mislav", "ana"};
            String[] completion = {"stanko", "ana", "mislav"};

            HashMap<Integer, String> ptMap = new HashMap<>();
            HashMap<Integer, String> cpMap = new HashMap<>();

            // 참가자들 해시에 저장
            // 입력된 참가자들 길이에 맞추어 반복실행
            for (int i = 0; i < participant.length; i++) {
                ptMap.put(i, participant[i]);
            }

            // 골인자들 해시에 저장
            for (int i = 0; i < completion.length; i++) {
                cpMap.put(i, completion[i]);
            }

            // 참가자와 완주자들사이의 비교
            for (int i = 0; i < completion.length; i++) {
                System.out.println(cpMap.get(i));
                for (int j = 0; j < participant.length; j++) {
                    if (cpMap.get(i).equals(ptMap.get(j))) {
                        System.out.println("ptMap = " + ptMap);
                        ptMap.remove(j);
                        break;
                    }
                }
                cpMap.remove(i);
            }

            String answer = null;
            for (Integer integer : ptMap.keySet()) {
                if (!ptMap.get(integer).isEmpty()) {
                    String s = ptMap.get(integer);
                    answer = s;
                }
            }

            System.out.println(answer);
        }
    }
}
