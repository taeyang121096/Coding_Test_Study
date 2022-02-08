package Programmers;

import java.util.*;

public class TripRoute {
    static boolean[] check;
    static String[][] T;
    static int size;
    static String ans = "";

    public static void main(String[] args) {
        String[][] tickets = {{"ICN,SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        T = tickets;
        String[] answer;
        check = new boolean[tickets.length];

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].compareTo(o2[0]) == 0) {
                    if (o1[1].compareTo(o2[1]) > 0) {
                        return 1;
                    }
                    return -1;
                }
                if (o1[0].compareTo(o2[0]) > 0) {
                    return 1;
                }
                return -1;
            }
        });

        size = T.length + 1;
        dfs("ICN", "ICN", 1);
        answer = ans.split("/");
    }

    static void dfs(String start, String tmp, int level) {
        // 종료 조건
        if (level == size) {
            ans = tmp;
            return;
        }

        for (int i = 0; i < T.length; i++) {
            if (ans.length() != 0)
                return;
            if (T[i][0].equals(start) && check[i] == false) {
                check[i] = true;
                dfs(T[i][1], tmp + "/" + T[i][1], level + 1);
                check[i] = false;
            }
        }
    }
}
