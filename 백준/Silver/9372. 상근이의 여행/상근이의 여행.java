import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 국가 수
            int m = Integer.parseInt(st.nextToken());   // 비행기 수
            int[][] airplanes = new int[n + 1][n + 1];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                airplanes[a][b] = 1;
                airplanes[b][a] = 1;
            }
            boolean[] visited = new boolean[n + 1];
            int cnt = bfs(1, n, airplanes, visited);
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }

    public static int bfs(int start, int n, int[][] airplanes, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (airplanes[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
