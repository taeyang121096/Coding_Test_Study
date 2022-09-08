class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        
        int min = a[0];
        for(int i = 0; i<a.length; i++){
            if(min > a[i]){
                min = a[i];
            }
            left[i] = min;
        }
        min = a[a.length-1];
        for(int i = a.length-1; i>=0; i--){
            if(min > a[i]){
                min = a[i];
            }
            right[i] = min;
        }
        
        for(int i = 0; i<a.length; i++){
            if(a[i]<=left[i] || a[i]<=right[i]){
                answer++;
            }
        }
        return answer;
    }
}