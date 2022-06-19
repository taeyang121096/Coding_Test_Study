package UnionFind;

public class UnionFind {
    static int[] parent = new int[10];
    static int find(int val){
        if(val == parent[val])
            return val;
        else
            return parent[val] = find(parent[val]);
    }
    static void union(int p,int c){
        p = find(p);
        c = find(c);
        if(p!=c)
            parent[c] = p;
    }

    /**
     * 1 : 1
     * 2 : 2
     * union(1,2) -> 1 : 1, 2 : 1
     * 3 : 3
     * union(2,3) -> find(3) -> 3, find(2) parent[2] -> 1;
     *  -> 3 : 1
     * @param args
     */
    public static void main(String[] args) {
        for(int i = 1;i<=9;i++){
            parent[i] = i;
        }
        union(1,2);
        union(2,3);
        union(4,5);
        union(5,6);
        union(7,8);
        union(3,9);
//        count boundary -?

        for(int i : parent)
            System.out.println(i);

    }
}
