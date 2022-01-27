import java.util.*;

public class Max_Kakao {


    static char[][] prior = {{'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '-', '+'},
            {'*', '+', '-'}
    };

    static Map<Character, Integer> map;

    static long max = 0;

    static ArrayList<String> num = new ArrayList<>();
    static ArrayList<Character> op = new ArrayList<>();

    static void separate(String exp) {
        for (char c : exp.toCharArray()) {
            if (!Character.isDigit(c))
                op.add(c);
        }
        for (String str : exp.replaceAll("[^0-9]", " ").split(" ")) {
            num.add(str);
        }
    }

    //     numstack -> -100
//     operstack ->
    static void calc() {
        Stack<Long> number = new Stack<>();
        Stack<Character> oper = new Stack<>();

        number.push(Long.parseLong(num.get(0)));

        for (int i = 0; i < op.size(); i++) {
            if (oper.isEmpty()) {
                oper.push(op.get(i));
                number.push(Long.parseLong(num.get(i + 1)));
            } else {
                if (map.get(oper.peek()) < map.get(op.get(i))) {
                    oper.push(op.get(i));
                    number.push(Long.parseLong(num.get(i + 1)));
                } else {
                    while (!oper.isEmpty() && map.get(oper.peek()) >= map.get(op.get(i))) {
                        long second = number.pop();
                        long first = number.pop();
                        char cal = oper.pop();
                        if (cal == '+') {
                            number.push(first + second);
                        } else if (cal == '-') {
                            number.push(first - second);
                        } else if (cal == '*') {
                            number.push(first * second);
                        }
                    }
                    oper.push(op.get(i));
                    number.push(Long.parseLong(num.get(i + 1)));
                }

            }
        }

        while (!oper.isEmpty()) {
            long second = number.pop();
            long first = number.pop();
            char cal = oper.pop();
            if (cal == '+') {
                number.push(first + second);
            } else if (cal == '-') {
                number.push(first - second);
            } else if (cal == '*') {
                number.push(first * second);
            }
        }

        max = Math.max(max, Math.abs(number.pop()));

    }

    public long solution(String expression) {


        separate(expression);

        for (char[] c : prior) {
            map = new HashMap<>();
            for (int i = 0; i < 3; i++)
                map.put(c[i], i);
            calc();
        }


        return max;
    }
}

