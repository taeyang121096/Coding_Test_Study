package kakao;
import java.util.*;
public class bad_User {
class Solution {
    String[] Uid;
    String[] Bid;
    boolean[] visit;
    int answer = 0;
    HashSet<String> hs = new HashSet<>();
    HashSet<HashSet<String>> ans = new HashSet<>();
    public void dfs(int index){
        if(index==Bid.length){
            ans.add(new HashSet<>(hs));
            return;
        }
            
        for(int i=0; i<Uid.length; i++){
            boolean check=true;    
            if(!visit[i] && Uid[i].length() == Bid[index].length()){
                for(int j=0; j<Bid[index].length(); j++){
                    if(Bid[index].charAt(j)=='*') continue;
                    if(Bid[index].charAt(j)!=Uid[i].charAt(j)) {check=false; break;}
                }
                if(check){
                    visit[i]=true;
                    hs.add(Uid[i]);
                    dfs(index+1);
                    hs.remove(Uid[i]);
                    visit[i]=false;
                }
            }
        }          
    }
    
    public int solution(String[] user_id, String[] banned_id) {
                
        Uid = user_id;
        Bid = banned_id;
        visit= new boolean[user_id.length];      
        dfs(0);      
        return ans.size();
    }
}
}
