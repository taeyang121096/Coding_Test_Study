/* 2021 KAKAO BLIND RECRUITMENT 광고삽입 */
package kakao;
class Solution {        
    static int[] time;
    
    public int getTime(String time){
        String[] s = time.split(":");
        int sumTime = Integer.parseInt(s[0])*3600 + Integer.parseInt(s[1])*60 + Integer.parseInt(s[2]);
        return sumTime;
    }
    
    public void getlog(String[] logs){
        for(String lg:logs){
            String[] s =lg.split("-");
            int start = getTime(s[0]);
            int end = getTime(s[1]);
            for(int i=start; i<end; i++){
                time[i]++;
            }
        }
    }
    public int findTime(String adv){
        int max_Time=0;
        long max=0;
        int ad = getTime(adv);
        for(int i=0; i<ad; i++){
            max += time[i];
        }
        int lt=0; 
        int rt=ad;
        long tmp = max;
        while(rt<time.length){
            tmp += time[rt++];
            tmp -= time[lt++];
            if(tmp>max){
                max_Time=lt;
                max=tmp;
            }
        }
        
        return max_Time;
    }
    public String ans(int max_time){
        StringBuilder sb = new StringBuilder();
        int hour = max_time/3600;
        int min = max_time%3600/60;
        int second = max_time%3600%60;
        if(hour<10){
            sb.append(0).append(hour).append(":");
        }else sb.append(hour).append(":");
        if(min<10){
            sb.append(0).append(min).append(":");
        }else sb.append(min).append(":");
        if(second<10){
            sb.append(0).append(second);
        }else sb.append(second);
        
        return sb.toString();
    }
    public String solution(String play_time, String adv_time, String[] logs) {
        
        String answer="";
        time=new int[getTime(play_time)+1];
        getlog(logs);
        int max_time = findTime(adv_time);
        answer = ans(max_time);
        
        return answer; 
    }
}

