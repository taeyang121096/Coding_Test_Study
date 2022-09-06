import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        int left = 0;
        for(int i = 0; i<len; i++){
            if(A[i] < B[len-1]){
                for(int j = left; j<len; j++){
                    if(A[i] < B[j]){
                        answer++;
                        left = j+1;
                        break;
                    }
                }
            }
            else{
                break;
            }
        }
        return answer;
    }
}