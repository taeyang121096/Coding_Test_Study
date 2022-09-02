// 도달한 플레이어 중의 클리어하지 못한 비율 -> 실패율
// 실패율을 내림차순 정렬하여 스테이지 번호를 리턴
// stage가 N일 경우 N + 1이면 모든 스테이지를 클리어 

import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] arr = new int[N+1];
        List<double[]> failrate = new ArrayList<>();
        
        for(int i = 0; i<stages.length; i++){
            arr[stages[i] - 1]++;
        }
        int count = arr[arr.length-1];
        for(int i = arr.length-2 ; i>=0; i--){
            if(arr[i]>0){
                count += arr[i];
                failrate.add( new double[] { i+1 , (double)arr[i] / count });
            }
            else{
                failrate.add( new double[] { i+1 , 0 });
            }
        }
        Comparator <double[]> comparator = new Comparator <double[]>(){
            @Override
            public int compare(double[]o1, double[]o2){
                if(o1[1] > o2[1]){
                    return -1;
                }
                else if(o1[1] == o2[1]){
                    return Double.valueOf(o1[0]).compareTo(Double.valueOf(o2[0]));
                }
                else{
                    return 1;
                }
            }
        };
        
        Collections.sort(failrate, comparator);
        
        int[] answer = new int[failrate.size()];
        count = 0;
        for(double[] tmp : failrate){
            answer[count++] = (int)tmp[0];
        }
        return answer;
    }
}