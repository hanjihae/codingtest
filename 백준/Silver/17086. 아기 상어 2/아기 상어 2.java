import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] sharks;
    static int[][] dist;
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sharks = new int[n][m];
        dist = new int[n][m];
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < m; j++) {
                sharks[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int max = 0;
        for (int i=0; i < n; i++) { // 상어 위치 초기화
            for (int j=0; j < m; j++) {
                if (sharks[i][j] == 1) {
                    queue.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];
            max = Math.max(max, dist);
            for (int[] d : dir) {
                int nx = cx + d[0];
                int ny = cy + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, dist + 1});
                }
            }
        }
        return max;
    }
}
