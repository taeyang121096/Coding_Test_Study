import java.util.*;
public class Pocket_Pro {
    static int count;
    class Solution {

        public int solution(int[] nums) {
            int answer = 0;
            count = nums.length/2;
            Set<Integer> set = new HashSet<>();
            for(int i : nums)
                set.add(i);
            if(count >= set.size())
                answer = set.size();
            else
                answer = count;
            return answer;
        }
    }
}
