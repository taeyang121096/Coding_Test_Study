import java.util.*;

public class Picture_KaKao {
    // A, C, F, J, M, N, R, T
//     =, > <
//     0 ~ 6
//     1. 순열인거 같다 -> 2. 조건을 통해서 거른다(카운트까지)
    static int count = 0;
    static String[] tmp = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static boolean[] flag;
    static String[] D;

    static void permu(String name) {
        if (name.length() == 8) {
            check(name);
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (flag[i])
                continue;
            flag[i] = true;
            permu(name + tmp[i]);
            flag[i] = false;
        }

    }

    //    str =  ABC  str.indexOf(A) => 0
    static void check(String name) {
        for (String data : D) {
            int First = name.indexOf(data.substring(0, 1));
            int Second = name.indexOf(data.substring(2, 3));
            char condition = data.charAt(3);
            int val = Integer.parseInt(data.substring(4, 5));

            if (condition == '=') {
                if ((int) Math.abs(First - Second) == val + 1) {
                    continue;
                }
                return;
            } else if (condition == '<') {
                if ((int) Math.abs(First - Second) < val + 1) {
                    continue;
                }
                return;
            } else if (condition == '>') {
                if ((int) Math.abs(First - Second) > val + 1) {
                    continue;
                }
                return;
            }

        }
        count++;
    }

    public int solution(int n, String[] data) {
        D = data;
        flag = new boolean[8];
        permu("");
        return count;
    }
}

