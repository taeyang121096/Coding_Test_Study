import java.util.*;
import java.io.*;
public class Inclination {
    static int[][] mat;
    static int n;
    static int l;
    static int count = 0;
    static ArrayList<int[]> list = new ArrayList<>();

    public static void check(){

        for(int[] tmp : list){
            boolean check[] = new boolean[n];
            boolean flag = true;
            int cnt = 0;
            int first = tmp[0];
            for(int i = 1;i<n;) {
                if (first == tmp[i]) {
                    i++;
                    continue;
                }
                if (Math.abs(first - tmp[i]) != 1) {
                    flag = false;
                    break;
                }
                if(first>tmp[i]){
                    if(checking(check,i,0,tmp)){
                        first = tmp[i];
                        i+=l;
                        continue;
                    }
                    flag = false;
                    break;
                }
                if(first<tmp[i]){
                    if(checking(check,i,1,tmp)){
                        first = tmp[i];
                        i++;
                        continue;
                    }
                    flag = false;
                    break;
                }
            }

            if(flag){
                count++;
            }

        }
    }
    static boolean checking(boolean[] check,int index,int by, int[] tmp ){
        if(by == 0) {
            if(index+l>n)
                return false;
            int val = tmp[index];
            for (int i = index; i < index + l; i++) {
                if(val != tmp[i] || check[i] == true)
                    return false;
                check[i] = true;
            }
            return true;
        }
        else{
            if(index-l<0)
                return false;
            int val = tmp[index-1];
            for (int i = index-1; i >= index - l; i--) {
                if(val != tmp[i] || check[i] == true)
                    return false;
                check[i] = true;
            }
            return true;
        }

    }
    public static void main(String[]args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        mat = new int[n][n];

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0;j<n;j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int[] x : mat){
            list.add(x);
        }
        for(int i = 0;i<n;i++){
            int[] tmp = new int[n];
            for(int j = 0;j<n;j++){
                tmp[j] = mat[j][i];
            }
            list.add(tmp);
        }
        check();
        System.out.println(count);

    }
}
