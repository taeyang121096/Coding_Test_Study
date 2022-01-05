package BaekJun;

import java.util.*;
import java.io.*;

public class B17413_reverse {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String input = br.readLine();
        char[] array = input.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if(stack.empty())
                return;
            else{
                stack.push(array[i]);
            }
        }
    }
}
