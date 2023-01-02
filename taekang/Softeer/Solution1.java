package Softeer;

public class Solution1 {
    public static void main(String[] args) {
        // two pointers, Collections.sorts
        // 1 4 5 8 7 6
        int[] arr = {1, 4, 5, 8, 7, 6};
//        int[] arr = {1, 3, 5, 4, 2};
        int k = 3;

        int answer = 0;
        int flag = 0;
        if (k == arr.length - 1) {
            answer = arr[k];
        } else {
            int left = 0;
            int right = arr.length - 1;
            for (int i = 0; i < k; i++) {
                if (arr[left] < arr[right]) {
                    flag = left;
                    left++;
                } else if (arr[left] > arr[right]) {
                    flag = right;
                    right--;
                }
            }
        }

        System.out.println(arr[flag]);
    }
}
