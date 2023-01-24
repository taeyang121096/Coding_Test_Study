class Solution {
    static int[] sales = {10, 20, 30, 40};
    static int[] answer = new int[2];
    static int[] sale_rate;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        sale_rate = new int[emoticons.length];
        dfs(users, emoticons, 0);
        
        return answer;
    }
    
    public void dfs(int[][] users, int[] emoticons, int depth){
        if(depth == emoticons.length){
            int plus = 0; 
            int money = 0;
            
            for(int i = 0; i < users.length; i++){
                int sale_limit = users[i][0];
                int sum_limit = users[i][1];
                int sum = 0;
                for(int j = 0; j < depth; j++){
                    if(sale_rate[j] >= sale_limit){
                        sum += emoticons[j] * (100 - sale_rate[j]) / 100;
                    }
                    if(sum >= sum_limit){
                        break;
                    }
                }
                if(sum >= sum_limit){
                    plus++;
                }
                else{
                    money += sum;
                }
            }
            if(plus > answer[0]){
                answer[0] = plus;
                answer[1] = money;
            }
            else if(plus == answer[0]){
                answer[1] = Math.max(answer[1], money);
            }
            return;
        }
        
        for(int i = 0; i < 4; i++){
            sale_rate[depth] = sales[i];
            dfs(users, emoticons, depth + 1);
        }
    }
}