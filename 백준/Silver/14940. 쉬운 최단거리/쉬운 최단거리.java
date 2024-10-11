import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = new int[n][m];
        visited = new boolean[n][m];
        boolean found = false;
        for (int i=0; i < n && !found; i++) {
            for (int j=0; j < m && !found; j++) {
                if (arr[i][j] == 2) {
                    bfs(i, j);
                    found = true;
                }
            }
        }
        // 방문하지 못한 위치는 -1로 설정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && ans[i][j] == 0) {
                    ans[i][j] = -1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[] {x, y});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];
            for (int i=0; i < 4; i++) {
                int a = nx + dx[i];
                int b = ny + dy[i];
                if (a >= 0 && b >= 0 && a < n && b < m && arr[a][b] == 1 && !visited[a][b]) {
                    queue.add(new int[] {a, b});
                    visited[a][b] = true;
                    ans[a][b] = ans[nx][ny] + 1;
                }
            }
        }
    }
}
