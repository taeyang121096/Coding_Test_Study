// 튜브가 미리 말할 숫자의 갯수가 t
// 진법 n, 인원 m, 튜브의 순서 p

class Solution {
    public String solution(int n, int t, int m, int p) {
        String tmp;
        StringBuilder sb = new StringBuilder();
        int turn = 1;
        int i = 0;
        int count = 0;
        
        while(count<t){
            tmp = Integer.toString(i++, n);
            for(int j = 0; j<tmp.length(); j++){
                if(count==t) break;
                if(turn == p){
                    sb.append(tmp.charAt(j));
                    count++;
                }
                turn++;
                if(turn>m){
                    turn = 1;
                }
            }
        }
        return sb.toString().toUpperCase();
    }
}