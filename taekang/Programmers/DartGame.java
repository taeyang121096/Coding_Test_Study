package Programmers;
import java.util.*;
public class DartGame {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        String dartResult = "1D2S0T";
        int answer = 0;
        // 숫자 가 있는 곳의 인덱스를 구함
        findIdx(dartResult);
        // 애초에 dartResult 의 길이는 최대 9임
        list.add(dartResult.length()); // 0 2 5 7
        // 1구간
        int n = list.get(1) - list.get(0);
        if(n == 2){
            int s = dartResult.charAt(list.get(0)) - '0';
            if(dartResult.charAt(list.get(0)+1) == 'S'){
                answer += s;
            } else if(dartResult.charAt(list.get(0)+1) == 'D'){
                answer += s*s;
            } else {
                answer += s*s*s;
            }
        } else if (n == 3){
            int s = dartResult.charAt(list.get(0)) - '0';
            if(dartResult.charAt(list.get(0)+1) == 'S'){
                answer += s;
            } else if(dartResult.charAt(list.get(0)+1) == 'D'){
                answer += s*s;
            } else {
                answer += s*s*s;
            }
            if(dartResult.charAt(list.get(0)+2) == '*'){
                answer = answer*2 + s*2;;
            } else {
                answer +=  s*-1;
            }
        }
        // 2구간
        int n2 = list.get(2) - list.get(1);
        if(n2 == 2){
            int s = dartResult.charAt(list.get(1)) - '0';
            if(dartResult.charAt(list.get(1)+1) == 'S'){
                answer += s;
            } else if(dartResult.charAt(list.get(1)+1) == 'D'){
                answer += s*s;
            } else {
                answer += s*s*s;
            }
        } else if (n2 == 3){
            int s = dartResult.charAt(list.get(1)) - '0';
            if(dartResult.charAt(list.get(1)+1) == 'S'){
                answer += s;
            } else if(dartResult.charAt(list.get(1)+1) == 'D'){
                answer += s*s;
            } else {
                answer += s*s*s;
            }
            if(dartResult.charAt(list.get(1)+2) == '*'){
                answer = answer*2 + s*2;
            } else {
                answer += s*-1;
            }
        }
        // 3구간
        int n3 = list.get(3) - list.get(2);
        if(n3 == 2){
            int s = dartResult.charAt(list.get(2)) - '0';
            if(dartResult.charAt(list.get(2)+1) == 'S'){
                answer += s;
            } else if(dartResult.charAt(list.get(2)+1) == 'D'){
                answer += s*s;
            } else {
                answer += s*s*s;
            }
        } else if (n3 == 3){
            int s = dartResult.charAt(list.get(2)) - '0';
            if(dartResult.charAt(list.get(2)+1) == 'S'){
                answer += s;
            } else if(dartResult.charAt(list.get(2)+1) == 'D'){
                answer += s*s;
            } else {
                answer += s*s*s;
            }
            if(dartResult.charAt(list.get(2)+2) == '*'){
                answer = answer*2 + s*2;
            } else {
                answer += s*-1;
            }
        }
    }
    static public void findIdx(String str){
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 48 && arr[i] < 57){
                list.add(i);
            }
        }
    }
}
