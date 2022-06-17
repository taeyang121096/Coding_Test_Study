//카펫
class Solution {
    public int[] solution(int brown, int yellow) {
        int y;
        int sum = (brown-4)/2;
        
        for(y = 0; y < sum; y++){
            if(y*(sum-y)==yellow)
                break;
        }
        int[] answer = {sum-y+2, y+2};
        return answer;
    }
}