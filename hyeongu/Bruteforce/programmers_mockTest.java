import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> al = new ArrayList<>();
        int[] answer;
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] correct = {0,0,0};
        int max = 0;
        int count = 0;
        
        for(int i = 0;i<answers.length;i++){
            if(answers[i]==first[i%5])
                correct[0]++;
            if(answers[i]==second[i%8])
                correct[1]++;
            if(answers[i]==third[i%10])
                correct[2]++;
        }
        for(int i = 0; i<3;i++){
            if(correct[i]>max)
                max = correct[i];
        }
        for(int i = 0;i<3;i++){
            if(correct[i]==max)
                al.add(i+1);
        }
        answer = new int[al.size()];
        for(int i = 0; i<al.size(); i++){
            answer[i] = al.get(i);
        }
        return answer;
    }
}