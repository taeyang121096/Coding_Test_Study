import java.util.*;

public class Mocktest_Prog {
    public int[] solution(int[] answers) {
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        int[] answer = {};
        // 1, 2, 3번 수포자들의 정답 패턴
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 1, 2, 3번 참가자들의 맞춘 개수 
        int first_answer = 0;
        int second_answer = 0;
        int third_answer = 0;
        
        // 답의 개수를 패턴의 길이로 나눠서 정답 배열과 비교
        // 정답이면 ++
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == first[i % first.length]){
                first_answer++;
            }
            if(answers[i] == second[i % second.length]){
                second_answer++;
            }
            if(answers[i] == third[i % third.length]){
                third_answer++;
            }
        }
        // 가장 많은 개수의 정답을 맞춘 수포자를 알아내기 위해  
        int max = Math.max(first_answer, Math.max(second_answer, third_answer));
        if(max == first_answer){
            al.add(1);
        }
        if(max == second_answer){
            al.add(2);
        }
        if(max == third_answer){
            al.add(3);
        }
        answer = new int[al.size()];
        
        for(int i = 0; i < al.size(); i++){
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}