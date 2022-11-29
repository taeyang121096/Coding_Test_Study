package Programmers;

public class FoodFight_Prog {
	public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < food.length; i++){
            if(food[i] % 2 == 1){
                food[i] = food[i] - 1;
            }
        }
        
        // 1 2 4 6
        
        for(int i = 1; i < food.length; i++){
            for(int j = 0; j < food[i]/2; j++){
                sb.append(i);
            }
        }
        answer.append(sb.toString());
        answer.append(0);
        answer.append(sb.reverse().toString());
        
        return answer.toString();
    }
}
