package BOJ;

import java.util.*;
import java.io.*;

public class SegMinAndMax_BOJ {

    static long[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new long[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree seg = new SegmentTree(n);
        seg.minInit(arr, 1, 1, n);
        seg.maxInit(arr, 1, 1, n);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            long min = seg.minFind(1, n, left, right, 1);
            long max = seg.maxFind(1, n, left, right, 1);
            sb.append(min + " " + max).append("\n");
        }
        System.out.println(sb.toString());
    }

    static class SegmentTree{
        private long[] maxTree;
        private long[] minTree;

        SegmentTree(int n){
            double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
            long treeNodeCount = Math.round(Math.pow(2, treeHeight));
            maxTree = new long[Math.toIntExact(treeNodeCount)];
            minTree = new long[Math.toIntExact(treeNodeCount)];
        }

        long maxInit(long[] arr, int node, int start, int end){
            if(start == end){
                return maxTree[node] = arr[start];
            }
            int mid = (start + end) / 2;

            return maxTree[node] = Math.max(maxInit(arr, node*2, start, mid), maxInit(arr, node*2 + 1, mid + 1, end));
        }

        long minInit(long[] arr, int node, int start, int end){
            if(start == end){
                return minTree[node] = arr[start];
            }
            int mid = (start + end) / 2;

            return minTree[node] = Math.min(minInit(arr, node*2, start, mid), minInit(arr, node*2 + 1, mid + 1, end));
        }

        long maxFind(int start, int end, int left, int right, int node){
            if(start > right || end < left){
                return 0;
            }

            if(left <= start && end <= right){
                return maxTree[node];
            }

            int mid = (start + end) / 2;
            return Math.max(maxFind(start, mid, left, right, node*2), maxFind(mid + 1, end, left, right, node*2 + 1));
        }

        long minFind(int start, int end, int left, int right, int node){
            if(start > right || end < left){
                return Integer.MAX_VALUE;
            }

            if(left <= start && end <= right){
                return minTree[node];
            }

            int mid = (start + end) / 2;
            return Math.min(minFind(start, mid, left, right, node*2), minFind(mid + 1, end, left, right, node*2 + 1));
        }
    }
}
