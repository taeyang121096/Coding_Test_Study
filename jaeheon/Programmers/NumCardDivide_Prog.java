package Programmers;

import java.util.*;

public class NumCardDivide_Prog {
	public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int gcdA = gcd(arrayA, arrayA[0]);
        int gcdB = gcd(arrayB, arrayB[0]);
        
        boolean flagA = check(arrayA, gcdB);
        boolean flagB = check(arrayB, gcdA);
        
        if(!flagA && !flagB){
            answer = 0;
        } else if(flagA && flagB){
            answer = Math.max(gcdA, gcdB);
        } else if(!flagA){
            answer = gcdA;
        } else if(!flagB){
            answer = gcdB;
        }
        
        return answer;
    }
    
    static int gcd(int[] arr, int min){
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] % min == 0){
                continue;
            } else {
                min--;
                i = -1;
            }
        }
        return min;
    }
    
    static boolean check(int[] arr, int gcd){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % gcd == 0){
                return false;
            } else {
                continue;
            }
        }
        return true;
    }
}
