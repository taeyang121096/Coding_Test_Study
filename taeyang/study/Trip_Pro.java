import java.util.*;

public class Trip_Pro {


    //     "ICN" - "JFK", "HND" - "IAD", "JFK" - "HND"
//     a -> b
//     항공권을 모두 사용한다
//     경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 한다.
//
    static boolean[] check;
    static String[][] T;
    static int size;
    static String ans = "";

    static void dfs(String start, String tmp, int level) {
        if (ans.length() != 0)
            return;
        if (level == size) {
            ans = tmp;
            return;
        }

        for (int i = 0; i < T.length; i++) {
            if (ans.length() != 0)
                return;
            if (T[i][0].equals(start) && check[i] != true) {
                check[i] = true;
                dfs(T[i][1], tmp + "/" + T[i][1], level + 1);
                check[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        String[] answer;
        T = tickets;
        check = new boolean[tickets.length];
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].compareTo(o2[0]) == 0) {
                    if (o1[1].compareTo(o2[1]) > 0)
                        return 1;
                    return -1;
                }
                if (o1[0].compareTo(o2[0]) > 0)
                    return 1;
                return -1;

            }
        });
        size = T.length + 1;
        dfs("ICN", "ICN", 1);

        answer = ans.split("/");

        return answer;
    }
}

