
/* Ä«Ä«¿À 2021 ±¤°í »ðÀÔ ¹®Á¦*/

class Solution {
    static int[] play;
    static long max = 0;
    static int ans = 0;
    
    public int time(String time){
        String[] start= time.split(":");
        int hour = Integer.parseInt(start[0]) * 3600;
        int min = Integer.parseInt(start[1]) * 60;
        int sec = Integer.parseInt(start[2]);
        return hour+min+sec;       
    }
    
    public void sum(String[] log){
        for(String s : log){
            String[] temp = s.split("-");
            int start = time(temp[0]);
            int end = time(temp[1]);
            for(int i = start;i<end;i++) play[i]+=1;
        }
        
    }
    public void check(String adv){
        int adv_time = time(adv);
        long sum = 0;
        for(int i = 0;i<adv_time;i++) sum += play[i];
        max = sum;
        ans = 0;
        int lt = 0,rt = adv_time;
        
        while(rt < play.length - 1){
            sum -= play[lt++];
            sum += play[rt++];
            if(sum> max) {
                max = sum;
                ans = lt;
            }
            
            
        }
        
    }
    
    public String ans(){
        int hour = ans / 3600;
        ans = ans%3600;
        int min = ans/60;
        ans = ans%60;
        int sec = ans;
        StringBuffer st = new StringBuffer();
        if(hour < 10) {
            st.append(0);
            st.append(hour);
        }else st.append(hour);
        st.append(":");
        if(min < 10) {
            st.append(0);
            st.append(min);
        }else st.append(min);
        st.append(":");
        if(sec < 10) {
            st.append(0);
            st.append(sec);
        }else st.append(sec);
        
        return st.toString();
        
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        play = new int[time(play_time)+1];
        sum(logs);
        check(adv_time);
        answer = ans();
                 
        
        return answer;
    }
}