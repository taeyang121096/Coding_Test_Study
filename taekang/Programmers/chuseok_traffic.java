package Programmers;

public class chuseok_traffic {
    static int[] traffic = new int[90000]; // 1초 단위의 배열..!!
    public static void main(String[] args) {
        String[] lines = {"2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s"};
        //t 시작지점 버림 끝나는 지점 올림
        for (String time : lines) {
            String[] tmp = time.split(" ");
            // 초로 바꿔준다
            String[] str = tmp[1].split(":");
            double val =
                    Double.parseDouble(str[0]) * 3600 + Double.parseDouble(str[1]) * 60 + Double.parseDouble(str[2]);
            tmp[2] = tmp[2].replace("s", "");
            double a = val - Double.parseDouble(tmp[2]) - 0.001;
            if(a < 0){
                a = 0;
            }

            int start = (int) a;
            int end = (int) Math.ceil(val) - (int) a;
            System.out.println(start + " " + end);
            second(start, end);
        }
        int max = 0;
        for (int i : traffic) {
            max = Math.max(max, i);
            //System.out.print(i + " ");
        }
        System.out.println(max);
    }

    static void second(int start, int end) {
        int i = 0;
        while (i <= end) {
            traffic[start + i] += 1; // traffic[75597] = 1
            i++;
        }
    }
}

