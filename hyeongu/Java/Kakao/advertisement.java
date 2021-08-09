import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int total = time_split(play_time);
        int ad = time_split(adv_time);
        int [] view = new int[total+1];
        long viewer = 0;
        int lp = 0;
        int rp = 0;
        long max = 0;
        int answer = 0;
        
        for(String index:logs){
            String[] str = index.split("-");
            int start = time_split(str[0]);
            int end = time_split(str[1]);
            
            for(int i = start;i<end;i++)
                view[i]++;
        }
        for(int i = 0; i<ad;i++){
            viewer += view[i];
            rp++;
        }
        max = viewer;
        
        for(;rp<total;rp++){
            viewer = viewer + view[rp] - view[lp];
            if(viewer>max){
                max = viewer;
                answer = lp+1;
            }
            lp++;
        }
            return make_time(answer);     
        }
    
    //HH:MM:SS로 나타낸 시간을 int로 변환
    public int time_split(String time_value){
        String[] split_String = time_value.split(":");
        
        int hour = Integer.parseInt(split_String[0]);
        int minute = Integer.parseInt(split_String[1]);
        int second = Integer.parseInt(split_String[2]);
        
        return (hour*3600)+(minute*60)+second;
    }
    
    //int로 나타낸 시간을 HH:MM:SS로 변환
    public String make_time(int time){
        StringBuilder sb = new StringBuilder();
        int hour = time/3600;
        int minute = (time%3600)/60;
        int second = (time%3600)%60;
        
        String s_hour = hour <10 ? "0" + hour : "" + hour;
        String s_minute = minute <10 ? "0" + minute : "" + minute;
        String s_second = second <10 ? "0" + second : "" + second;

        sb.append(s_hour).append(":");
        sb.append(s_minute).append(":");
        sb.append(s_second);
        
        return sb.toString();
    }
}