package Programmers;
import java.util.*;

public class JjackGGung {
    public static void main(String[] args) {
        String X = "21474836479";
        String Y = "21474836479";
        StringBuilder sb = new StringBuilder();
        int[] X_arr = new int[10]; // X
        int[] Y_arr = new int[10]; // Y
        for(int i = 0; i < X.length(); i++){
            int c = X.charAt(i)-'0';
            X_arr[c]++;
        }
        for(int i = 0; i < Y.length(); i++){
            int c = Y.charAt(i)-'0';
            Y_arr[c]++;
        }
        if(X.length() >= Y.length()){
            for(int i = 0; i < 10; i++){
                if(X_arr[i] > 0 && Y_arr[i] > 0){
                    if(X_arr[i] - Y_arr[i] >= 0){
                        for(int j = 0; j < Y_arr[i]; j++){
                            sb.append(String.valueOf(i));
                        }
                    } else {
                        for(int j = 0; j < X_arr[i]; j++){
                            sb.append(String.valueOf(i));
                        }
                    }
                }
            }
        } else {
            for(int i = 0; i < 10; i++){
                if(X_arr[i] > 0 && Y_arr[i] > 0){
                    if(Y_arr[i] - X_arr[i] >= 0){
                        for(int j = 0; j < X_arr[i]; j++){
                            sb.append(String.valueOf(i));
                        }
                    } else {
                        for(int j = 0; j < Y_arr[i]; j++){
                            sb.append(String.valueOf(i));
                        }
                    }
                }
            }
        }

        String tmp = sb.toString();
        if(tmp.equals("")) System.out.println("-1");
        else if(Long.parseLong(tmp) == 0) System.out.println("0");
        String answer = "";

        char[] arr = tmp.toCharArray();
        Arrays.sort(arr);

        for(int i = arr.length-1; i >=0; i--){
            answer += arr[i];
        }
        System.out.println(answer);
    }
}
