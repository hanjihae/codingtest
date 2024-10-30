import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ans = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int prev = -1;
        for (int i=0; i < n; i++) {
            if (prev == arr[i]) continue;   // arr 내 중복되는 수 제외
            ans[index] = arr[i];
            // 인덱스가 0보다 크고 이전 값이 다음 값보다 큰 경우 제외
            if (index > 0 && ans[index -1] > ans[index]) continue;
            dfs(index + 1);
            prev = arr[i];
        }
    }
}
