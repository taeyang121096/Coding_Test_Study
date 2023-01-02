//class Solution {
//    public int solution(int storey) {
//        int answer = 0;
//
//        String str = String.valueOf(storey);
//
//        int[] arr = new int[str.length()+1];
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = storey%10;
//            storey/=10;
//        }
//
//        // 4 5 5 2
//        for(int i = 0; i < arr.length; i++){
//            if(i != arr.length - 1){
//                if(arr[i] < 5){
//                    answer += arr[i];
//                } else if(arr[i]>5){
//                    answer += 10-arr[i]; //
//                    arr[i]=0;
//                    arr[i+1]++;
//                } else {
//                    if(arr[i+1]>=5){
//                        answer += arr[i];
//                        arr[i] = 0;
//                        arr[i+1]++;
//                    } else if(arr[i+1]<5){
//                        answer+=arr[i];
//                        arr[i]=0;
//                    }
//                }
//            } else {
//                if(arr[i] <= 5){
//                    answer += arr[i];
//                } else {
//                    answer += 10-arr[i]; //
//                    answer++;
//                }
//            }
//
//            for(int j = i; j < arr.length; j++){
//                if(arr[j] >= 10){
//                    arr[j]-=10;
//                    arr[j+1]++;
//                }
//            }
//
//            // for(int j = 0; j < arr.length; j++){
//            //     System.out.print(arr[j]+" ");
//            // }
//            // System.out.println();
//        }
//
//        return answer;
//    }
//}