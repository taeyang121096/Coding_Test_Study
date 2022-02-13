package Programmers;

class NumSum_Prog {
    public int solution(int[] numbers) {
        int answer = 0;
        int sum = 45;
        int tmp = 0;
        
        for(int i = 0; i < numbers.length; i++){
            tmp += numbers[i];
        }
        answer = sum - tmp;
        
        return answer;
    }
}