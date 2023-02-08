class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] time = new int[1450];
        
        for(int i = 0; i < book_time.length; i++){
            String[] start = book_time[i][0].split(":");
            int start_time = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            String[] end = book_time[i][1].split(":");
            int end_time = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
            
            for(int j = start_time; j < end_time ; j++){
                time[j]++;
            }
        }
        
        for(int i = 0; i < 1450; i++){
            answer = Math.max(answer, time[i]);
        }
        
        return answer;
    }
}