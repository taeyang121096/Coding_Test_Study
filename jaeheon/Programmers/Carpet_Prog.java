
//프로그래머스 완전탐색 카펫
public class Carpet_Prog {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int rowPlusCol = (brown + 4)/2;
        int col = 3;
        int row = rowPlusCol - col;
        
        // brown = 2*i + 2*(j-2) i+j=(brown+4)/2
        while(row >= 3 && col <= row){
            if((row - 2) * (col - 2) == yellow){
                answer[0] = row;
                answer[1] = col;
                break;
            }
            row--;
            col++;
        }
        
        return answer;
    }
}