import java.io.*;
import java.util.*;
 
public class baek_2751 {
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
 
		insertionSort(A);
		
		for(int i = 0; i< N; i++) {
			sb.append(A[i]).append('\n');
		}
		System.out.println(sb);
	}
	
	//내장함수
	public static void Sort(int[] arr) {
		Arrays.sort(arr);
	}
	
	//버블정렬
	public static void bubbleSort(int[] arr) {
	    for(int i = 0; i < arr.length; i++) {
	        for(int j = 0 ; j < arr.length - i - 1 ; j++) {
	            if(arr[j] > arr[j+1]) {
	                int temp = arr[j+1];
	                arr[j+1] = arr[j];
	                arr[j] = temp;
	            }
	        }
	    }
	}
	
	//선택정렬
	public static void selectionSort(int[] arr) {
		for(int i = 0; i<arr.length -1;i++) {
			int min = i;
			
			for(int j= i+1; j < arr.length;j++) {
				if(arr[j]<arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	
	//삽입정렬
	public static void insertionSort(int[] arr) {
		for(int i = 1; i<arr.length -1;i++) {
			int temp = arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j]>temp) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
}