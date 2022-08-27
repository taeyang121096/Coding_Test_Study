import java.util.*;

class Solution {
    public int answer;
    public boolean[] visit;
    public boolean check;
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        answer = words.length + 1;
        dfs(begin, target, words, 0);
        if(!check)  return 0;
        return answer;
    }
    
    public void dfs(String now, String target, String[] words, int depth){
        if(now.equals(target)){
            answer = Math.min(answer, depth);
            check = true;
            return;
        }
        for(int i = 0; i<words.length; i++){
            if(visit[i]){
                continue;
            }
            int cnt = 0;
            for(int j = 0; j<now.length(); j++){
                if(now.charAt(j) == words[i].charAt(j)){
                    cnt++;
                }
            }
            if(cnt == now.length() -1){
                visit[i] = true;
                dfs(words[i], target, words, depth+1);
                visit[i] = false;
            }
        }
    }
}