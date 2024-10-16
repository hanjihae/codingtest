import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m, n;
    static int[][] tomato;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        tomato = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) { // 익은 토마토
                    queue.add(new int[] {i, j});
                }
            }
        }
        System.out.println(bfs(queue));
    }

    public static int bfs(Queue<int[]> queue) {
        int days = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i < size; i++) {
                int[] now = queue.poll();
                int x = now[0];
                int y = now[1];
                for (int j=0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    // 범위 안에 있는 칸이고 토마토가 익지 않은 경우
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && tomato[nx][ny] == 0) {
                        tomato[nx][ny] = 1; // 토마토 익히기
                        queue.add(new int[] {nx, ny});  // 익힌 토마토 큐에 저장
                    }
                }
            }
            if (!queue.isEmpty()) { // 큐가 비어있지 않으면 일수 추가
                days++;
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (tomato[i][j] == 0) {
                    return -1; // 익지 않은 토마토가 있으면 -1 반환
                }
            }
        }
        return days;
    }
}
