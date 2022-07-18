// 2x2 형태로 붙어있을경우 블록이 사라짐
// 2x2 형태가 겹쳐져있어도 동시에 사라짐
// 사라진 블럭의 갯수를 return
// 빈공간은 아래로 채움
// m -> 높이(문자열 개수) n -> 폭(문자열 길이) 2<=n, m<=30

import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        // 배열을 뒤집어서 생각하기 때문에 n, m으로 초기화
        boolean[][] check = new boolean[n][m];
        int answer = 0;
        boolean isBreak;
        ArrayList<Character>[] arr = new ArrayList[n]; 
        
        for(int i = 0; i<n; i++){
            arr[i] = new ArrayList<Character>();
        }
        for(int i = m; i>0; i--){
            for(int j = 0; j<n; j++){
                arr[j].add(board[i-1].charAt(j));
            }
        }
        // for(int i = 0; i<n; i++){
        //     for(int j = 0; j<m; j++){
        //         System.out.print(arr[i].get(j));
        //     }
        //     System.out.println(""); 
        // }
                
        do{
            //삭제하는 블럭이 있을경우 true, 없는경우 while문 종료
            isBreak = false;
            for(int i = 0; i<n-1; i++){
                for(int j = 0; j<arr[i].size()-1; j++){
                    if(arr[i+1].size()<=j+1){
                        break;
                    }
                    if(arr[i].get(j)==arr[i].get(j+1)){
                        if(arr[i+1].get(j)==arr[i+1].get(j+1)&&arr[i].get(j)==arr[i+1].get(j)){
                            check[i][j] = true;
                            check[i][j+1] = true;
                            check[i+1][j] = true;
                            check[i+1][j+1] = true;
                            isBreak = true;
                        }
                    }
                }
            }
            for(int i = 0; i<n; i++){
                for(int j = arr[i].size()-1; j>=0; j--){
                    if(check[i][j]){
                        arr[i].remove(j);
                        answer++;
                        check[i][j] = false;
                    }
                }
            }
        }while(isBreak);
        return answer;
    }
}