class Solution {
    public int[][] arr;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        arr = new int[n+1][m+1];
        for(int i = 0; i<puddles.length; i++){
            arr[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(arr[i][j] == -1){
                    arr[i][j] = 0;
                    continue;
                }
                if(i == 1 && j == 1){
                    arr[i][j] = 1;
                }
                else if(i == 1){
                    arr[i][j] = arr[i][j-1];
                }
                else if(j == 1){
                    arr[i][j] = arr[i-1][j];
                }
                else{
                    arr[i][j] = (arr[i][j-1] + arr[i-1][j]) %  1000000007;
                }
            }
        }
        return arr[n][m];
    } 
}