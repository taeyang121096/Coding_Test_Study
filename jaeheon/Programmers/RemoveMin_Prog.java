package Programmers;

class RemoveMin_Prog {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }
        
        
        int[] answer = new int[arr.length - 1];
        
        int tmp = arr[0];
        for(int i = 1; i < arr.length; i++){
            tmp = Math.min(tmp, arr[i]);
        }
        
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == tmp){
                continue;
            }
            answer[index++] = arr[i];
        }
        
        return answer;
    }
}