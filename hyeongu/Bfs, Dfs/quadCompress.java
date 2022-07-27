// 0과 1로 이루어진 한 변의 길이가 2^n인 정사각 행렬
// 행렬을 4등분하고 그 안의 숫자가 모두 동일할 경우 하나의 숫자로 압축
// 최종적으로 남는 0과 1의 갯수 리턴

class Solution {
    public int[][] array;
    public int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        array = arr;
        
        int last = dfs(0, 0, arr.length);
        if(last == 1){
            answer[1]++;
        }
        else if (last == 0){
            answer[0]++;
        }
        return answer;
    }
    
    public int dfs(int x, int y, int n){
        if(n == 1){
            return array[x][y];
        }
        
        int a = dfs(x, y, n/2);
        int b = dfs(x+n/2, y, n/2);
        int c = dfs(x, y+n/2, n/2);
        int d = dfs(x+n/2, y+n/2, n/2);
        
        if(a==b&&c==d&&a==c){
            return a;
        }
        if(a!=-1){
            answer[a]++;
        }
        if(b!=-1){
            answer[b]++;
        }
        if(c!=-1){
            answer[c]++;
        }
        if(d!=-1){
            answer[d]++;
        }
        return -1;
    }
}