public class N_Pro {

    static int answer = -1;

    static void dfs(int n, int num, int val, int cnt) {

        if (cnt > 8) return;

        if (num == val) {
            if (answer == -1) answer = cnt;
            else
                answer = Math.min(cnt, answer);
            return;
        }
        int x = 0;
        for (int i = 0; i < 8; i++) {
            x = x * 10 + n;
            dfs(n, num, val + x, cnt + 1 + i);
            dfs(n, num, val - x, cnt + 1 + i);
            dfs(n, num, val * x, cnt + 1 + i);
            dfs(n, num, val / x, cnt + 1 + i);

        }


    }

    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return answer;
    }
}

