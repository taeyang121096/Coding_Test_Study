package Programmers.chocalate.move_move;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        int[] answer = new int[2];
        String s = "2021:04:12:16:08:35";
        String[] times = {"01:06:30:00", "01:04:12:00"};

        String[] split_s = s.split(":");
        int year = Integer.parseInt(split_s[0]);
        int month = Integer.parseInt(split_s[1]);
        int day = Integer.parseInt(split_s[2]);
        int hour = Integer.parseInt(split_s[3]);
        int minute = Integer.parseInt(split_s[4]);
        int second = Integer.parseInt(split_s[5]);


        boolean flag = false;
        int sumDay = 1;

        for (int i = 0; i < times.length; i++) {
            split_s = times[i].split(":");
            int next_day = Integer.parseInt(split_s[0]);
            int next_hour = Integer.parseInt(split_s[1]);
            int next_minute = Integer.parseInt(split_s[2]);
            int next_second = Integer.parseInt(split_s[3]);


            if (second + next_second >= 60) {
                second += next_second - 60;
                minute++;
            } else {
                second += next_second;
            }

            if (minute + next_minute >= 60) {
                minute += next_minute - 60;
                hour++;
            } else {
                minute += next_minute;
            }

            if (hour + next_hour >= 24) {
                hour += next_hour - 24;
                next_day++;
            } else {
                hour += next_hour;
            }

            // 만약 day 몫이 2가 되어버리면 1일 1저축은 실패하게됨,
            if (day + next_day > 30) {
                if(next_day > 1){
                    flag = true;
                }
                sumDay += next_day;

                day = (day + next_day) % 30;
                month += (day + next_day) / 30;
            } else {
                if(next_day > 1){
                    flag = true;
                }
                sumDay += next_day;
                day += next_day;
            }

            if (month > 12) {
                month -= 12;
                year++;
            }
        }

        if(flag) answer[0] = 0;
        else answer[0] = 1;

        answer[1] = sumDay;

        System.out.println(answer[0] + " " + answer[1]);
    }
}
