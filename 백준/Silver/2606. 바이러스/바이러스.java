import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine()); // 네트워크 상에서 연결된 컴퓨터 쌍의 수
        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = true;
            graph[v][u] = true; // 양방향 연결
        }
        int infectedCount = dfs(1) - 1; // 1번 컴퓨터 제외
        System.out.println(infectedCount);
    }

    public static int dfs(int node) {
        visited[node] = true;
        int count = 1;
        for (int i = 1; i < graph.length; i++) {
            if (graph[node][i] && !visited[i]) {
                count += dfs(i);
            }
        }
        return count;
    }
}
