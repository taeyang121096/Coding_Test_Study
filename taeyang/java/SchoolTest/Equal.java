package School;
import java.util.*;

public class Equal {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[]arr = new int[n];

        int index = 0;
        for(String str : sc.nextLine().split(" ")){
            arr[index++] = Integer.parseInt(str);
        }
        Arrays.sort(arr);
        int mid = arr.length/2;
        int first = 0;
        int second = 0;
        for(int i = mid;i<arr.length;i++){
            if(first<=second)
                first += arr[i];
            else
                second += arr[i];
        }
        for(int i = mid-1;i>=0;i--){
            if(first<=second)
                first += arr[i];
            else
                second += arr[i];
        }
        System.out.println(Math.abs(first-second));






    }
}
