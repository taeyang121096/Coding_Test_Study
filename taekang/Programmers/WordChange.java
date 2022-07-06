//class Solution {
//    static int answer = 51;
//    static boolean[] visit;
//
//    static boolean check(String now, String next){
//        int cnt = 0;
//        for(int i = 0; i < next.length(); i++){
//            if(now.charAt(i) == next.charAt(i)){
//                cnt++;
//            }
//        }
//        if(cnt == next.length() - 1){
//            return true;
//        } else{
//            return false;
//        }
//    }
//
//    static void dfs(int depth, String target, String[] words, String now){
//        if(now.equals(target)){
//            answer = Math.min(answer, depth);
//            return;
//        }
//
//        for(int i = 0; i < words.length; i++){
//            String next = words[i];
//            if(visit[i] == false && check(now, next)){
//                visit[i] = true;
//                dfs(depth + 1, target, words, next);
//                visit[i] = false;
//            }
//        }
//    }
//
//    public int solution(String begin, String target, String[] words) {
//        visit = new boolean[words.length];
//        for(int i = 0; i < words.length; i++){
//            String next = words[i]; //
//            if(!visit[i] && check(begin, words[i])){
//                visit[i] = true;
//                dfs(1, target, words, next);
//                visit[i] = false;
//            }
//        }
//        if(answer == 51){
//            return 0;
//        } else{
//            return answer;
//        }
//    }
//}