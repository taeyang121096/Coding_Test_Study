import java.util.*;

public class ParkPrice_Kakao {
//     입차 , 출차 기록
//     기본 시간, 기본 요금, 단위 시간, 단위 요금
//     00 : 00 ~ 23 : 59 까지 누적 주차 시간
//     기본 시간 이하 기본요금
//     기본 시간 초과 기본요금 + 단위시간 요금
//     단위 시간으로 나누어 떨어지지 않으면, 올림
//     차량번호가 작은 자동차 부터
//     record 1 ~ 1000
//     sorting 하면 된다. hashmap ??

    static int ot;
    static int op;
    static int ut;
    static int up;
    static int end;
    static TreeMap<String, List<Integer>> in = new TreeMap<>();
    static TreeMap<String, List<Integer>> out = new TreeMap<>();
    static List<Integer> ls = new ArrayList<>();

    static void calcP(int time) {

        int price = 0;
        if (time <= ot) {
            price += op;
        } else {
            price += op;
            time -= ot;
            time = (int) Math.ceil((double) time / (double) ut);
            price += time * up;
        }
        ls.add(price);
    }

    static void calcT() {
        for (String key : in.keySet()) {
            List<Integer> inner = in.get(key);
            int sumT = 0;
            if (out.containsKey(key)) {
                List<Integer> outter = out.get(key);
                for (int i = 0; i < inner.size(); i++) {
                    if (i < outter.size()) {
                        sumT += outter.get(i) - inner.get(i);
                    } else {
                        sumT += end - inner.get(i);
                    }
                }
            } else {
                for (int i = 0; i < inner.size(); i++) {
                    sumT += end - inner.get(i);
                }
            }
            calcP(sumT);
        }
    }

    static int changeMin(String time) {
        String[] tmp = time.split(":");
        int t = 0;
        t += Integer.parseInt(tmp[0]) * 60;
        t += Integer.parseInt(tmp[1]);
        return t;
    }

    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        ot = fees[0];
        op = fees[1];
        ut = fees[2];
        up = fees[3];
        end = changeMin("23:59");
        for (String r : records) {
            String[] tmp = r.split(" ");
            int time = changeMin(tmp[0]);
            if (tmp[2].equals("IN")) {
                if (in.containsKey(tmp[1])) {
                    in.get(tmp[1]).add(time);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(time);
                    in.put(tmp[1], list);
                }
            } else {
                if (out.containsKey(tmp[1])) {
                    out.get(tmp[1]).add(time);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(time);
                    out.put(tmp[1], list);
                }
            }
        }
        calcT();
        answer = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++)
            answer[i] = ls.get(i);
        return answer;
    }
}
