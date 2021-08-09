import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
      
        for(int i = 0; i<prices.length;i++){
            while(true){
                //스택이 비어잇을 경우 push
                if(stack.empty()){
                    stack.push(i);
                }
                //새로운 주식의 가격이 기존보다 낮을경우 pop
                else if(prices[stack.peek()]>prices[i]){
                    answer[stack.peek()] = i - stack.pop();
                }
                //새로운 주식의 가격이 기존보다 높을경우 push한 후 break
                else{
                    stack.push(i);
                    break;
                }
            }
        }
        //스택에 남아있는 값을 pop하면서 answer계산
        while(!stack.empty()){
            answer[stack.peek()] = prices.length - stack.pop() - 1;
        }
        return answer;
    }
}