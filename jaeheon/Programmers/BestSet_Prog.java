package Programmers;

//합이 최대 -> 곱이 최대
//n : 원소의 개수 1 ~ 10000
//s : 원소의 합 1 ~ 100,000,000
//태양 가설 : s를 n으로 나눔 -> 몫에다가 더해주면서 비교

class BestSet_Prog {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(n > s){
            int[] result = { -1 };
            return result;
        }
        
        for(int i = 0; i < n; i++){
            answer[i] = s / n;
        }
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum+=answer[i];
        }
        
        for(int i = n-1; i >= n-(s - sum); i--){
            answer[i]++;
        }
        
        return answer;
    }
}