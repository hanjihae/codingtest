import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, s;
    static int cnt;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());   // 원소 더한 값
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        // sum이 0부터 시작하니까 s가 0인 경우 카운트-1
        System.out.println(s == 0 ? cnt - 1 : cnt);
    }

    public static void dfs(int index, int sum) {
        if (index == n) {
            if (sum == s) { // 합계가 s라면
                cnt++;  // 카운트
            }
            return;
        }
        dfs(index + 1, sum + arr[index]);   // 현재 값 포함한 합계
        dfs(index + 1, sum);    // 현재 값 포함하지 않은 합계
    }
}
