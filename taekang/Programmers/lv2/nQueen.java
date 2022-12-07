//class Solution {
//    public int[] choice;
//    public int answer = 0;
//    public int solution(int n) {
//
//        choice = new int[n];
//        dfs(0,n);
//
//        return answer;
//    }
//
//    public boolean isPossible(int depth){
//        for(int i = 0; i < depth; i++){
//            // 같은 열에 있거나, 가로세로가 같거나
//            if(choice[i] == choice[depth] || Math.abs(choice[i] - choice[depth]) == Math.abs(depth - i)){
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    public void dfs(int depth, int n){
//        if(depth == n){
//            answer++;
//            return;
//        }
//
//        for(int i = 0; i < n; i++){
//            choice[depth] = i;
//            if(isPossible(depth)){
//                dfs(depth+1, n);
//            }
//        }
//    }
//}