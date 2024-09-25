import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static boolean[] visited;
    public static int[][] arr;
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        arr = new int[n + 1][n + 1];
        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = 1;
            arr[v][u] = 1;
        }
        cnt = 0;
        for (int i=1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int u) {
        visited[u] = true;
        for (int i=1; i <= n; i++) {
            if (arr[u][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
