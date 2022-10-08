class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i<=n; i++){
            while(true){
                answer++;
                if(answer % 3 != 0 && answer % 10 != 3 && (answer / 10) % 10 != 3){
                    break;
                }
            }
        }
        return answer;
    }
}