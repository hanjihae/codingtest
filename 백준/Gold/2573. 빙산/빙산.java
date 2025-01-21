import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1년마다 동서남북 방향 0이 저장된 칸 개수만큼 줄어듬
// 몇 년후에 빙산이 두 덩어리로 나눠질지 출력 / 아무리 해도 두 덩어리 안되면 0 출력
public class Main {
    static int n, m;
    static int[][] icebergs; // 빙산 높이 배열
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        icebergs = new int[n][m];
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < m; j++) {
                icebergs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int year = 0;
        while (true) {
            int cnt = countIcebergs();
            if (cnt == 0) {
                System.out.println(0);
                break;
            } else if (cnt > 1) {
                System.out.println(year);
                break;
            }
            meltIceBergs();
            year++;
        }

    }

    // 빙산 녹이기
    private static void meltIceBergs() {
        int[][] melt = new int[n][m];   // 동서남북 방향 0칸 개수 저장할 배열
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (icebergs[i][j] > 0) {
                    for (int k=0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m && icebergs[nx][ny] == 0) {
                            melt[i][j]++;
                        }
                    }
                }
            }
        }
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) { // 현재 빙산 높이에서 0칸 개수만큼 빼기
                icebergs[i][j] = Math.max(0, icebergs[i][j] - melt[i][j]);
            }
        }
    }

    // 빙산이 몇 덩어리 남았는지 카운트
    public static int countIcebergs() {
        visited = new boolean[n][m];
        int cnt = 0;
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (icebergs[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i=0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && icebergs[nx][ny] > 0 && !visited[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
