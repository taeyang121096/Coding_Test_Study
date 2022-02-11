package Programmers;

class Network_Prog {
    static boolean[] isChecked;
    
    public void dfs(int i, int[][] computers){
        isChecked[i] = true;
        
        for(int j = 0; j < computers.length; j++){
            if(isChecked[j] == false && computers[i][j] == 1){
                dfs(j, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        isChecked = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(isChecked[i] == false){
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }
}