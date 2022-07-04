// n은 12 이하 -> 모든 경우 카운트
// 가로, 세로 대각선 겹치지 않게
// 방법의 수 리턴

import java.util.*;

class Solution {
    static int a;
    static int answer;
    static int[] mat;
    
    static void find(int[] mat, int col){
        if(col == a){
            answer++;
        } else {
            for(int i = 1; i <= a; i++){
                mat[col + 1] = i;
                if(check(mat, col + 1)){
                    find(mat, col + 1);
                }
            }
        }
    }
    
    static boolean check(int[] map, int col){
        for(int i = 1; i < col; i++){
            if(mat[i] == mat[col]){
                return false;
            }
            if(Math.abs(i - col) == Math.abs(mat[i] - mat[col])){
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n) {
        
        a = n;
        
        for (int i = 1; i <= a; i++) {
         mat = new int[n + 1];
         mat[1] = i;
         find(mat, 1);
      }
        
        return answer;
    }
}