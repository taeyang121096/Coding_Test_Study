package algorithmTest.NewStudy;
import java.util.*;
public class Hotel {

    class Solution {
        //     10분간 청소
//     1. 마지막 시간에 10분 -> 60 기준으로 1시간 더하기
//     2. 0000 ~ 2359 까지 배열
        public int hourToMin(String time){
            int hour = Integer.valueOf(time.substring(0,2));
            int min = Integer.valueOf(time.substring(2,4));

            return min += (hour * 60);
        }
        public int solution(String[][] book_time) {
            int answer = 0;

            List<int[]> timeList = new ArrayList<>();
            int[] timeCnt = new int[1440];
            for(String[] time : book_time){
                int start = hourToMin(time[0].replace(":",""));
                int end = hourToMin(time[1].replace(":",""))+10;
                timeList.add(new int[]{start,end});
            }

            for(int[] time : timeList){
                for(int i = time[0];i<=time[1];i++){
                    timeCnt[i] += 1;
                }
            }

            answer = Arrays.stream(timeCnt).max().getAsInt();


            return answer;
        }
    }
}
