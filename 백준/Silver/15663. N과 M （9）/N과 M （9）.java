import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;
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
        visited = new boolean[n];
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
        for (int i = 0; i < n; i++) {
            // 방문한 적 없고, 이전 숫자와 현재 숫자가 다를 때
            if (!visited[i] && (prev == -1 || prev != arr[i])) {
                visited[i] = true;
                ans[index] = arr[i];
                prev = arr[i];  // 수 저장해서 다음값과 비교
                dfs(index + 1);
                visited[i] = false;
            }
        }
    }
}
