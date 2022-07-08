package Programmers;

public class Hang_Mul {
    public static void main(String[] args) {
        int[][] arr1 = {{2,3,2}, {4,2,4}, {3,1,4}};
        int[][] arr2 = {{5,4}, {2,4}, {3,1}};

        //arr1 : [[2, 3, 2], [4, 2, 4], [3, 1, 4]]
        //arr2 : [[5, 4], [2, 4], [3, 1]]
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr1.length; i++){ //
            for(int j = 0; j < arr2[0].length; j++){
                // answer[i][j] += arr1[i][0] * arr2[0][j] + arr1[i][1] * arr2[1][j];
                // answer[i][j] += arr1[i][j]*arr2[j][0];
                for(int k = 0; k < arr1[0].length;k++){
                    answer[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }
}
