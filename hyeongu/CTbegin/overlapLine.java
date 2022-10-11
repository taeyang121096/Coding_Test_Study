class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] arr = new int[210];
        for(int i = 0; i<lines.length; i++){
            if(lines[i][0]>lines[i][1]){
                for(int j = lines[i][1] + 100; j < lines[i][0] + 100; j++){
                    arr[j]++;
                }
            }
            else{
                for(int j = lines[i][0] + 100; j < lines[i][1] + 100; j++){
                    arr[j]++;
                }
            }
        }
        
        for(int i = 0; i<200; i++){
            if(arr[i] > 1){
                answer++;
            }
        }
        return answer;
    }
}