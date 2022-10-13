///**
// 개인정보 보호를 위해 아이디 중 일부 문자를 * 로 가림
// **/
//import java.util.*;
//class Solution {
//    public String[] choice;
//    public boolean[] check;
//    public int len, user_len;
//    public Set<String> set = new LinkedHashSet<>();
//
//    public int solution(String[] user_id, String[] banned_id) {
//        int answer = 0;
//
//        user_len = user_id.length;
//        len = banned_id.length;
//
//        choice= new String[len];
//        check = new boolean[user_len];
//
//        dfs(len, 0, user_id, banned_id);
//
//        // for(String s : set){
//        //     System.out.println(s);
//        // }
//
//        return set.size();
//    }
//
//    public void checkBan(String[] banned_id){
//        String[] ans = new String[len];
//        boolean[] visited = new boolean[len]; // {t, f}
//
//        for(int i = 0; i < len; i++){ // banned 에 대한 반복문 {fr*d*, abc1**}
//            String ban = banned_id[i]; // "fr*d*"
//
//            for(int j = 0; j < len; j++){ // choice 에 대한 반복문 {frodo, fradi}
//                String user = choice[j];
//
//                if(!visited[j]){
//                    if(ban.length() == user.length()){ //
//                        boolean flag = false;
//
//                        for(int k = 0; k < user.length(); k++){ // banned 과 user의 단어 길이에 대한 반복문
//                            if(ban.charAt(k) == '*'){
//                                continue;
//                            } else {
//                                if(ban.charAt(k) == user.charAt(k)){
//                                    continue;
//                                } else {
//                                    flag = true;
//                                    break;
//                                }
//                            }
//                        }
//                        // flag= true이면 실패한거니까, 만약 false 그대로면
//                        if(!flag){
//                            visited[j] = true;
//                            ans[i] = user;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        // for(int i = 0 ; i < len; i++){
//        //    System.out.print(ans[i] + " ");
//        // }
//        // System.out.println();
//
//        boolean f = false;
//        for(int i = 0 ; i < len; i++){
//            if(ans[i] == null){
//                f = true;
//            }
//        }
//
//        if(!f){
//            Arrays.sort(ans);
//
//            String tmp = "";
//            for(int i = 0 ; i < len; i++){
//                tmp += ans[i];
//            }
//
//            set.add(tmp);
//        }
//    }
//
//    public void dfs(int N, int depth, String[] user_id, String[] banned_id){
//        if(N == depth){
//            checkBan(banned_id);
//            return;
//        }
//
//        for(int i = 0; i < user_len; i++){
//            if(!check[i]){
//                check[i] = true;
//                choice[depth] = user_id[i];
//                dfs(N, depth+1, user_id, banned_id);
//                check[i] = false;
//            }
//        }
//    }
//}