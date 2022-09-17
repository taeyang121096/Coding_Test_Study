package Programmers;

import java.util.*;

public class DHCP_devc {
    public static void main(String[] args) {
        int n = 2;
        /**
         198.168.0 ~ 1 : n개, ip 할당, ip 반납
         */
        String[] queries = {"desktop1 request",
                "desktop2 request",
                "desktop1 release",
                "desktop2 release",
                "desktop3 request",
                "desktop3 release",
                "desktop2 request",
                "desktop1 request"
        };

        boolean[] ip = new boolean[n]; // new boolean[2] {true} {false}
        HashMap<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            String[] str = queries[i].split(" ");
            String name = str[0]; // desktop1
            String want = str[1]; // request
            boolean flag = true;
            if (want.equals("request")) {
                if (!map.containsKey(name)) {
                    for (int j = 0; j < n; j++) {
                        if (!ip[j]) {
                            list.add(name + " 192.168.0." + String.valueOf(j + 1));
                            map.put(name, ("192.168.0." + String.valueOf(j + 1)));
                            ip[j] = true;
                            flag = false;
                            break;
                        }
                    }
                    if (flag) list.add(name + " reject");
                } else { // 만약 map에 이미 있어 그럼 그게 먼저 사용중인지 확인하고, 사용중이면 for문 돌려서 ㄱ
                    String lastChar = map.get(name).substring(map.get(name).length() - 1); // 인덱스, 1 2
                    if (!ip[Integer.parseInt(lastChar) - 1]) { // !false 사용가능하다 !! 하면
                        list.add(name + " 192.168.0." + lastChar);
                        map.put(name, ("192.168.0." + lastChar));
                        ip[Integer.parseInt(lastChar) - 1] = true;
                    } else { // 이미 사용중이면
                        for (int j = 0; j < n; j++) {
                            if (!ip[j]) {
                                list.add(name + " 192.168.0." + String.valueOf(j + 1));
                                map.put(name, ("192.168.0." + String.valueOf(j + 1)));
                                ip[j] = true;
                                flag = false;
                                break;
                            }
                        }
                        if (flag) list.add(name + " reject");
                    }
                }
            } else { // release 일때는 어케 해야하나 ?
                String lastChar = map.get(name).substring(map.get(name).length() - 1);
                ip[Integer.parseInt(lastChar) - 1] = false; // 찾아서 false로 바꿔준다
            }
        }
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
/**
 * "desktop1 192.168.0.1",
 * "desktop2 192.168.0.2",
 * "desktop3 192.168.0.1",
 * "desktop2 192.168.0.2",
 * "desktop1 192.168.0.1"
 */