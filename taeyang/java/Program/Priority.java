import java.util.*;

public class Priority {


    //
//     4가지 정보 -> info 1 ~ 50,000 -> info
//     query -> 1 ~ 100,000
//     return -> 숫자를 순서에 맞게 return
//     1. c, java, python, 2. backend,frontend, 3. junior, senior, 4. chicken, pizza, 5. 1 ~ 100,000
//     스페이스바로 구분
//     - 고려 x, X <=
//     1. 조합으로 key list를 만든다
//     2. query를 바탕으로 key를 비교 해본다.
//
//
    static Set<String> key = new HashSet<>();
    static List<String[]> klist = new ArrayList<>();

    static void combination(int level, String[] con, String str, String[] k) {
        if (level == con.length) {
            if (key.contains(str)) {
                return;
            }
            key.add(str);
            klist.add(k.clone());
            return;
        }
        k[level] = con[level];
        combination(level + 1, con, str + con[level], k);
        k[level] = "-";
        combination(level + 1, con, str + "-", k);

    }

    static int calc(String[] tmp) {
        int cnt = 0;
        for (String[] k : klist) {
            boolean flag = true;
            for (int i = 0; i < 5; i++) {
                if (k[i] == "-" || k[i] == tmp[i]) {
                    continue;
                } else if (i == 4 && Integer.parseInt(k[i]) >= Integer.parseInt(tmp[i])) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        return cnt;
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String condition : info) {
            String[] con = condition.split(" ");
            combination(0, con, "", new String[5]);
        }

        for (int i = 0; i < query.length; i++) {
            String qu = query[i].replaceAll(" and", "");
            String[] tmp = qu.split(" ");
            answer[i] = calc(tmp);
        }


        return answer;
    }
}

