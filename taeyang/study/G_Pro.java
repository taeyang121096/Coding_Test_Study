import java.util.*;
public class G_Pro {

    class Solution {
        //     도달 거리 w
//     최소 좌우 총 거리
//     한번의 탐색으로
//     n 20억
        public int solution(int n, int[] stations, int w) {
            int answer = 0;
            List<int[]> list = new ArrayList<>();
            for(int s : stations)
                list.add(new int[]{s-w,s+w});
            int start = 1;
            int val = 2*w+1;
            int size = 0;
            for(int[] tmp : list){
                size = 0;
                if(start > n)
                    break;
                if(start < tmp[0]){
                    size += tmp[0]-start;
                    start = tmp[1]+1;
                }else if(start == tmp[0]){
                    start = tmp[1]+1;
                }else if(start > tmp[0]){
                    if(tmp[1] < start){
                        size += start - tmp[1];
                        start += 1;
                    }else{
                        start = tmp[1]+1;
                    }

                }
                answer += size/val;
                if(size%val !=0)
                    answer += 1;
            }
            if(start <=n){
                size = 0;
                size += n - start+1;
                answer += size/val;
                if(size%val !=0)
                    answer += 1;
            }


            return answer;
        }
    }
}
