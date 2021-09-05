import java.util.*;
class Solution {

    static List[] id;
    static Set<Set<String>> ans = new HashSet<>();

    void caseNum(String[] user_id, String[] banned_id, Set<String> set){

        if(set.size() == banned_id.length){
            if(checks(set,banned_id)){
                ans.add(new HashSet<>(set));
            }
            return;
        }


        for(String user :user_id){
            if(!set.contains(user)){
                set.add(user);
                caseNum(user_id,banned_id,set);
                set.remove(user);
            }
        }

    }
    boolean checks(Set<String> set, String[] banned_id){
        int i = 0;
        for(String user : set){
            if(!check(user,banned_id[i++])){
                return false;
            }
        }
        return true;
    }


    boolean check(String s, String b){
        if(s.length() != b.length())
            return false;
        for(int i = 0;i<s.length();i++){
            if(b.charAt(i)=='*')
                continue;
            if(b.charAt(i) != s.charAt(i))
                return false;
        }
        return true;
    }


    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        caseNum(user_id,banned_id,new LinkedHashSet<String>());


        answer = ans.size();




        return answer;
    }
}