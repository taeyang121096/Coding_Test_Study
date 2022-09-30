class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int i = 0;
        while(sum + i < n){
            sum += i++;
            if((n - sum) % i == 0){
                answer++;
            }
        }        
        return answer;
    }
}