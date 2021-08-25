/*
2021 Dev-Matching:웹 백엔드 개발자(상반기) 행렬 테두리 회전하기
*/
package kakao;

public class Matrixborder {
  class Solution {
    
    int row;
    int column;
    int min;
    int[][] arr;
    public int rotation(int[] query){
        
        min=Integer.MAX_VALUE;         
        int x1=query[0]-1;
        int y1=query[1]-1;
        int x2=query[2]-1;
        int y2=query[3]-1;
        
        min=Math.min(min,arr[x1][y2]);
        int tmp=arr[x1][y2];
        for(int i=y2; i>y1; i--){
            arr[x1][i]=arr[x1][i-1];
            min=Math.min(min,arr[x1][i]);
        }
        
        int tmp2=arr[x2][y2];
        min=Math.min(min,arr[x2][y2]);
        for(int i=x2; i>x1+1; i--){
            arr[i][y2]=arr[i-1][y2];
            min=Math.min(min,arr[i][y2]);
        }
        arr[x1+1][y2]=tmp;
        
        int tmp3=arr[x2][y1];
        min=Math.min(min,arr[x2][y1]);
        for(int i=y1; i<y2-1; i++){
            arr[x2][i]=arr[x2][i+1];
            min=Math.min(min,arr[x2][i]);
        }
        arr[x2][y2-1]=tmp2;
        
        for(int i=x1; i<x2-1; i++){
            arr[i][y1]=arr[i+1][y1];
            min=Math.min(min,arr[i][y1]);
        }
        arr[x2-1][y1]=tmp3;
        
        return min;
    }    
    public int[] solution(int rows, int columns, int[][] queries) {
        
        row=rows;
        column=columns;     
        arr=new int[rows][columns];
        int index=1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[i][j]=index++;
            }
        }
        
        int[] answer = new int[queries.length];
        
        for(int i=0; i<queries.length; i++){
            int ans = rotation(queries[i]);
            answer[i]=ans;
        }
        
        return answer;
    }
}
}
