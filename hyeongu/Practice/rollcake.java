class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] arr1 = new int[10001];
        int[] arr2 = new int[10001];
        int size1 = 0;
        int size2 = 0;
        
        for(int i = 0; i<topping.length; i++){
            if(arr2[topping[i]] == 0){
                size2++;
            }
            arr2[topping[i]]++;
        }
        
        for(int i = 0; i< topping.length; i++){
            if(arr1[topping[i]] == 0){
                size1++;
            }
            arr1[topping[i]]++;
            arr2[topping[i]]--;
            if(arr2[topping[i]] == 0){
                size2--;
            }
            
            if(size1 == size2){
                answer++;
            }
        }
        return answer;
    }
}