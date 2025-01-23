import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 주어진 연산자 모두 사용해서 최댓값/최솟값 구하기
public class Main {
    static int n;
    static int[] a;
    static int[] op;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, a[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int cur) {
        if (depth == n) {
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            return;
        }
        for (int i=0; i < 4; i++) {
            if (op[i] > 0) {    // 사용한 연산자 제거
                op[i]--;
                if (i == 0) { // +
                    dfs(depth + 1, cur + a[depth]);
                } else if (i == 1) { // -
                    dfs(depth + 1, cur - a[depth]);
                } else if (i == 2) { // *
                    dfs(depth + 1, cur * a[depth]);
                } else if (i == 3) { // /
                    dfs(depth + 1, divide(cur, a[depth]));
                }
                op[i]++;    // 복구
            }
        }
    }

    private static int divide(int cur, int a) {
        if (cur < 0) {  // 분모가 음수라면
            return -(-cur / a);
        } else {
            return cur / a;
        }
    }
}
