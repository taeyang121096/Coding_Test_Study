import java.util.*;

public class Time_Pro {


    //     시작은 올림
//     끝은 버림
//     ->2, 3 , 4, 5, 6, 7
//     33.020 - 0.011 => 33.10  , 58.233 - 1.181 ->    7.052
//     57.07, 57.42
//     57.   -> 58.233
//     초로 바꾼 배열 하나 필요
//     초로 바꾸는 함수 필요
//     24 * 3600 + 60 * 60+60 = 3660+86400 = 90060
    static int[] times = new int[90061];
    static int[] multi = new int[90061];

    static void calc(String finish, String time) {
        String t[] = finish.split(":");
        double fin = Double.parseDouble(t[0]) * 3600 + Double.parseDouble(t[1]) * 60 + Double.parseDouble(t[2]);
        double work = Double.parseDouble(time);
        double start = fin - work;
        System.out.println(start + " " + fin + " " + work);
        if (start < 0) {
            for (int i = 0; i <= (int) fin; i++)
                times[i] += 1;
        } else {
            for (int i = (int) start; i <= (int) fin; i++)
                times[i] += 1;
        }


    }

    public int solution(String[] lines) {
        int answer = 0;

        for (String l : lines) {
            String[] tmp = l.split(" ");
            calc(tmp[1], tmp[2].replace("s", ""));
        }
        for (int i = 0; i < times.length; i++) {
            if (times[i] != 0)
                System.out.println(i + " :" + times[i]);
        }
        answer = Arrays.stream(times).max().getAsInt();

        return answer;
    }
}

