// n행 n열 2차원 배열
// i행 i열까지 비어있는 숫자를 i로 채움
// 1차원 배열로 모두 이어붙인 후 left~right return

class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right-left+1);
        int[] answer = new int[len];
        int count = 0;
        
        for(long i = left; i<=right; i++){
            int row  = (int)(i/n);
            int col = (int)(i%n);
            
            answer[count++] = Math.max(row, col) + 1;
            // if(row>col){
            //     answer[count++] = row+1;
            // }
            // else{
            //     answer[count++] = col+1;
            // }
        }
        return answer;
    }
}