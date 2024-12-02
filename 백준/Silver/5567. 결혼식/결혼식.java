import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] friends;
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        friends = new int[n + 1][n + 1];
        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a][b] = 1;
            friends[b][a] = 1;
        }
        visited = new boolean[n + 1];
        bfs(1);
        System.out.println(cnt);
    }

    public static void bfs(int node) {
        Queue<int[]> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(new int[] {node, 0}); // 동기 번호, 상근이와 거리
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int dist = cur[1];
            if (dist == 2) return;
            for (int i=1; i <= n; i++) {
                if (friends[num][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    cnt++;
                    queue.add(new int[] {i, dist + 1});
                }
            }
        }
    }
}
