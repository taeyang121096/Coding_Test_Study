package BOJ;

import java.util.*;
import java.io.*;

public class SectionMul_BOJ {
    static long[] arr;
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree seg = new SegmentTree(n);
        seg.init(arr, 1, 1, n);

        for(int i = 0; i < m + k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                seg.update(1, n, b, c, 1);
                continue;
            }
            sb.append(seg.mul(1, n, b, c, 1)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static class SegmentTree{
        private long[] tree;

        SegmentTree(int n){
            double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
            long treeNodeCount = Math.round(Math.pow(2, treeHeight));
            tree = new long[Math.toIntExact(treeNodeCount)];
        }

        long init(long[] arr, int node, int start, int end){
            if(start == end){
                return tree[node] = arr[start];
            }
            int mid = (start + end) / 2;

            return tree[node] = init(arr, node*2, start, mid) * init(arr, node*2 + 1, mid + 1, end) % MOD;
        }

        long update(int start, int end, int idx, int diff, int node){
            if(idx < start || end < idx){
                return tree[node];
            }

            if(start == end){
                return tree[node] = diff;
            }

            int mid = (start + end) / 2;
            return tree[node] = update(start, mid, idx, diff, node*2) *
                                update(mid + 1, end, idx, diff, node*2 + 1) % MOD;

        }

        long mul(int start, int end, int left, int right, int node){
            if(start > right || end < left){
                return 1;
            }

            if(left <= start && end <= right){
                return tree[node];
            }

            int mid = (start + end) / 2;
            return mul(start, mid, left, right, node*2) * mul(mid + 1, end, left, right, node*2 + 1) % MOD;
        }
    }
}
