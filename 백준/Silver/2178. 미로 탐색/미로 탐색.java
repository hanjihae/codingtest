import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[][] dist;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        for(int i=1; i <= n; i++) {
            String[] input = br.readLine().split("");
            for (int j=1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(input[j-1]);
            }
        }
        visited = new boolean[n + 1][m + 1];
        dist = new int[n + 1][m + 1];
        int res = bfs(1, 1);
        System.out.println(res);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        dist[x][y] = 1;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];
            for(int i=0; i < 4; i++) {
                int a = nx + dx[i];
                int b = ny + dy[i];
                // 범위 내에 방문하지 않은 길이 있다면
                if (a > 0 && b > 0 && a <= n && b <= m && arr[a][b] == 1 && !visited[a][b]) {
                    queue.add(new int[] {a, b});
                    visited[a][b] = true;
                    dist[a][b] = dist[nx][ny] + 1;
                    // 만약 (n, m) 위치에 도달했다면 그 지점의 거리값 반환
                    if (a == n && b == m) {
                        return dist[a][b];
                    }
                }
            }
        }
        return -1;
    }
}
