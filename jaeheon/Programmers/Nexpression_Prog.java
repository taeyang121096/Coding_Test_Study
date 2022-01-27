package Programmers;
// 5+5, 5-5, 5*5, 5/5  12를 만들도록 재귀
// 5, 55, 555, 5555 이런 애들 처리 -> num * 10 + num

class Nexpression_Prog {
    
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int N, int number) {
        make(N, number, 0, 0);
        if(answer > 8){
            return -1;
        }
        return answer;
    }
    
    static void make(int n, int num, int cnt, int sum){
        if(cnt > 8){
            return;
        }
        if(sum == num){
            answer = Math.min(cnt, answer);
        }
        int tmp = 0;
        for(int i = 1; i <= 8; i++){ // 0~7 -> 1~8
            tmp = tmp * 10 + n;
            //사칙연산
            make(n, num, cnt + i, sum + tmp);
			make(n, num, cnt + i, sum - tmp);
			make(n, num, cnt + i, sum / tmp);
			make(n, num, cnt + i, sum * tmp);
        }
    }
}