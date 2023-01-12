import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        double number = (double)k;
        List<Double> al = new ArrayList<>();
        al.add(number);
        
        while(number > 1){
            if(number % 2 == 0){
                number /= 2;
            }    
            else{
                number = number * 3 + 1;
            }
            al.add(number);
        }
        
        for(int i = 0; i < ranges.length; i++){
            int left = ranges[i][0];
            int right = al.size() - 1 + ranges[i][1];
            
            if(right < left){
                answer[i] = -1.0;
                continue;
            }
            
            double tmp = 0.0;
            for(int j = left; j < right ; j++){
                tmp += (al.get(j) + al.get(j+1))/2;
            }
            answer[i] = tmp;
        }
        
        return answer;
    }
}