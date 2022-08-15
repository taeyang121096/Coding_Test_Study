package Programmers;

public class lv1_makeSoSu {
    static public int[] arr;
    static public int answer = 0;
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        arr = new int[3];
        dfs(nums.length, 3, 0, 0, nums);
        System.out.println(answer);
    }
    public static void dfs(int N, int M, int select, int idx, int[] nums){
        if(M == select){
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += nums[arr[i]];
            }
            if(isPrime(sum)) answer++;

            return;
        }
        if(idx >= N){
            return;
        }
        // 선택
        arr[select] = idx;
        dfs(N, M, select + 1, idx + 1, nums);
        // no 선택
        dfs(N, M, select, idx + 1, nums);
    }
    public static boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
