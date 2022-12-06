package Programmers.lv2;

import java.util.*;

public class MakeMax {
    public static HashSet<Character> set = new HashSet<>();
    public static ArrayList<Long> operand_list = new ArrayList<>();
    public static ArrayList<Character> operator_list = new ArrayList<>();

    public static char[] arr;
    public static boolean[] visited;
    public static long max = 0;

    public static void main(String[] args) {
        System.out.println(solution("50*6-3*2"));
    }

    public static long solution(String expression) {
        long answer = 0;

        for (int i = 0; i < expression.length(); i++) {
            if (!(expression.charAt(i) >= 48 && expression.charAt(i) <= 57)) {
                set.add(expression.charAt(i));
            }
        }

        arr = new char[set.size()];
        visited = new boolean[set.size()];
        int idx = 0;
        for (char c : set) {
            arr[idx++] = c;
        }

        dfs(0, "", expression);

        return max;
    }

    public static void dfs(int depth, String str, String expression) {
        if (depth == set.size()) {
            getAnswer(str, expression);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, str + arr[i], expression);
                visited[i] = false;
            }
        }
    }

    public static void getAnswer(String str, String expression) {
        // + + -
        // 0   1   2   3
        // 100 200 300 500 20
        //
        String tmp = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) >= 48 && expression.charAt(i) <= 57) {
                tmp += expression.charAt(i);
            } else {
                operand_list.add(Long.parseLong(tmp));
                operator_list.add(expression.charAt(i));
                tmp = "";
            }
        }
        operand_list.add(Long.parseLong(tmp));

        for (int i = 0; i < str.length(); i++) {
            char nowOperator = str.charAt(i);

            while (operator_list.size() != 0) {
                int idx = operator_list.indexOf(nowOperator);
                if (idx == -1) {
                    break;
                } else {
                    if (nowOperator == '+') {
                        operand_list.add(idx, operand_list.get(idx) + operand_list.get(idx + 1));
                    } else if (nowOperator == '*') {
                        operand_list.add(idx, operand_list.get(idx) * operand_list.get(idx + 1));
                    } else {
                        operand_list.add(idx, operand_list.get(idx) - operand_list.get(idx + 1));
                    }
                    operand_list.remove(idx + 1);
                    operand_list.remove(idx + 1);

                    operator_list.remove(idx);
                }
            }
        }
        max = Math.max(max, Math.abs(operand_list.get(0)));
        operand_list.clear();
        operator_list.clear();
    }
}
