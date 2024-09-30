import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m;
    public static boolean[][] visited;
    public static char[][] campus;
    public static int cnt;

    public static int dx, dy;
    public static int[] row = {0, 0, -1, 1};
    public static int[] col = {-1, 1, 0, 0};

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        campus = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                campus[i][j] = input.charAt(j);
                if (campus[i][j] == 'I') {  // 도연이 위치
                    dx = i;
                    dy = j;
                }
            }
        }
        cnt = 0;
        bfs(dx, dy);    // 도연이 위치에서 탐색 시작

        if (cnt == 0) { // 아무도 못 만난 경우 TT 출력
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pos.x + row[i];
                int ny = pos.y + col[i];
                // 범위 밖이거나 이미 방문했거나 벽(X) 경우 제외
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || campus[nx][ny] == 'X') {
                    continue;
                }
                // 사람을 만났을 때 카운트
                if (campus[nx][ny] == 'P') {
                    cnt++;
                }
                visited[nx][ny] = true; // 방문 처리
                queue.add(new Point(nx, ny));   // 추가 탐색
            }
        }
    }
}
