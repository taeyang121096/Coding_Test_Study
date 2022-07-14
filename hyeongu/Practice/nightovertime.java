// n시간 후에 남은 작업의 피로도가 최소가 되도록
// 골고루 작아지는 것이 제곱해서 더했을때 최소

import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int[] arr = new int[50001];
        int max = 0;
        int tmp = 0;
        
        for(int i : works){
            arr[i]++;
            tmp+=i;
            if(i>max){
                max = i;
            }
        }
        if(tmp<n){
            return 0;
        }
        for(int i = max; i>0; i--){
            if(n==0){
                break;
            }
            if(n>=arr[i]){
                arr[i-1] += arr[i];
                n-=arr[i];
                arr[i] = 0;
                max = i-1;
            }
            else{
                arr[i] -= n;
                arr[i-1] +=n;
                n = 0;
                break;
            }            
        }
        for(int i = 1; i<=max; i++){
            if(arr[i]>0){
                answer += Math.pow(i, 2) * arr[i];
            }
        }
        return answer;
    }
}