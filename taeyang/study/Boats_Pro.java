import java.util.*;
public class Boats_Pro {

    class Solution {
        //
//
//     0  1  2  3
//     10 20 80 80 -> 90 start++ end -- start ++ end -- -> while
//     50 50 70 80 ->    start   end -- start end --  start ++ end -- -> while -> count
//
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);
            int start = 0;
            int end = people.length-1;

            while(start<=end){

                if(people[start]+people[end] <=limit)
                    start++;

                answer++;

                end--;

            }

            return answer;
        }
    }
}
