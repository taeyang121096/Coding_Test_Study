class Solution {
    static boolean[] visit;
    static int n;
    static int max = 0;
    static int[] arr;
    
    public int solution(int[] cards) {
        n = cards.length;
        arr = cards;
        
        for(int i = 0; i < n; i++){
            visit = new boolean[n];
            visit[i] = true;
            first(cards[i] - 1, 1);
        }
        return max;
    }
    
    public void first(int num, int cnt){
        if(!visit[num]){
            visit[num] = true;
            first(arr[num] - 1, cnt + 1);
        }
        else{
            for(int i = 0; i < n; i++){
                if(!visit[i]){
                    visit[i] = true;
                    second(arr[i] - 1, cnt, 1);
                    visit[i] = false;
                }
            }
        }
    }
    
    public void second(int num, int first_cnt, int cnt){
        if(!visit[num]){
            visit[num] = true;
            second(arr[num] - 1, first_cnt, cnt + 1);
            visit[num] = false;
        }
        else{
            max = first_cnt * cnt > max ? first_cnt * cnt : max;
        }
    }
}