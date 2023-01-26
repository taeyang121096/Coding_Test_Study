import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        int[] arr = new int[numbers.length];
        Arrays.fill(arr, -1);
        
        Stack<int[]> st = new Stack<>();
        st.push(new int[] {numbers[0], 0});
        
        for(int i = 1; i < numbers.length; i++){
            while(!st.isEmpty()){
                int[] now = st.pop();
                
                if(numbers[i] > now[0]){
                    arr[now[1]] = numbers[i];
                }
                else{
                    st.push(now);
                    break;
                }
            }
            st.push(new int[] {numbers[i], i});
        }
        
        
        return arr;
    }
}