import java.util.*;
public class MinRect {


    class Solution {

        public int solution(int[][] sizes) {
            int answer = 0;
            int size = sizes.length;
            int max0 = 0;
            int max1 = 0;
            for(int i = 0;i<size;i++){
                max0 = Math.max(sizes[i][0],max0);
                max1 = Math.max(sizes[i][1],max1);
            }
            int cate = -1;
            if(max0==max1)
                cate = 2;
            else if(max0>max1)
                cate = 0;
            else cate = 1;
            for(int i = 0;i<size;i++){
                if(cate == 0){
                    if(max1 <= sizes[i][0] || sizes[i][0] >= sizes[i][1] )
                        continue;
                    sizes[i][1] = sizes[i][0];
                }

                if(cate == 1){
                    if(max0 <= sizes[i][1] || sizes[i][1] >= sizes[i][0])
                        continue;
                    sizes[i][0] = sizes[i][1];
                }
                if(cate == 2){
                    if(sizes[i][1] >= sizes[i][0])
                        continue;
                    sizes[i][0] = sizes[i][1];
                }
            }

            if(cate == 0){
                int max = 0;
                for(int i = 0;i<size;i++){
                    max = Math.max(max,sizes[i][1]);
                }
                return max * max0;
            }else if(cate == 1){
                int max = 0;
                for(int i = 0;i<size;i++){
                    max = Math.max(max,sizes[i][0]);
                }
                return max*max1;
            }
            else{
                int max = 0;
                for(int i = 0;i<size;i++){
                    max = Math.max(max,sizes[i][0]);
                }
                return max1 *max;
            }

        }
    }
}
