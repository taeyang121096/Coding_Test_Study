// 전체 학생의 수는 2~30
// 여벌 체육복이 있는 경우 양옆의 학생에게 빌려줄수있음
// 체육복은 1개만 도난당할 수 있으며 도난당할경우 빌려줄 수 없음
// 체육복을 가지는 최댓값을 return
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n];
        Arrays.fill(student, 1);
        
        for(int i = 0; i<lost.length; i++){
            student[lost[i]-1]--;
        }
        for(int i = 0; i<reserve.length; i++){
            student[reserve[i]-1]++;
        }
        if(student[0]>1){
            if(student[1]<1){
                student[0]--;
                student[1]++;
            }
        }
        if(student[n-1]>1){
            if(student[n-2]<1){
                student[n-1]--;
                student[n-2]++;
            }
        }
        for(int i = 1; i<student.length-1; i++){
            if(student[i]>1){
                if(student[i-1]<1){
                    student[i]--;
                    student[i-1]++;
                }
                else if(student[i+1]<1){
                    student[i]--;
                    student[i+1]++;
                }
            }
        }
        for(int i = 0; i<student.length; i++){
            if(student[i]>0){
                answer++;
            }
        }
        return answer;
    }
}