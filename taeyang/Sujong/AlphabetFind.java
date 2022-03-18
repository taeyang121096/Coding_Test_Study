package Sujong;
import java.io.*;
import java.util.*;
/*
 1. a ~ z 까지 값을 넣구나(나오는 idx값을 넣구나)
 2. 단어의 길이 <100

 1. a ~ z -> char -> int -> 아스키 a - z +1 ->
 2. int[] arr -> len('z' -'a' +1) -> a(0)b(1)cdefg
 Arrays.fill(arr,-1); -> 1차원 배열만
  -1-1-1-1-1--1-1-
 3. String word = readLine()
 4. for(i ~ word.length() -> word.charAt(i)
     word.charAt(i) -> 'b' - 'a' = arr[i] = 'b' - 'a';
 6. 'a'(0) ~ 'z'(last) ->
 7. i = 0 -> 'b' -> ans['b'-'a' -> 1] = i
 8. i = 1 -> 'a' -> ans['a' -'a' -> 0] = 1

 */
public class AlphabetFind {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int z = 'z';
        int a = 'a';
        String[] alphabet = new String[z-a+1];
        Arrays.fill(alphabet,"-1");
        String word = br.readLine();

        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(alphabet[c-a].equals("-1")) {
                alphabet[c - a] = String.valueOf(i);
            }
        }
        System.out.println(String.join(" ",alphabet));
    }
}
