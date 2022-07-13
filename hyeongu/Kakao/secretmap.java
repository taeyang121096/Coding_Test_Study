import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb;
        for(int i = 0; i<n; i++){
            sb = new StringBuilder();
            String tmp = Integer.toString(arr1[i] | arr2[i], 2);
            int size = tmp.length();
            
            while(size<n){
                sb.append(" ");
                size++;
            }
            for(int k = 0; k<tmp.length(); k++){
                if(tmp.charAt(k)=='1'){
                    sb.append("#");
                }
                else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}