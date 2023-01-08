class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;

        for (long val = l; val <= r; val++) {
            answer += query(n, val - 1);
        }

        return answer;
    }

    int query(int n, long l) {
        if (n == 0 || l == 0)
            return 1;
        if (l % 5 == 2)
            return 0;
        return query(n - 1, l / 5);
    }

}
