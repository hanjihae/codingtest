import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m, n, h;
    static int[][][] tomato;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1}; // 상, 하
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());   // 상자 가로 칸 수
        n = Integer.parseInt(st.nextToken());   // 상자 세로 칸 수
        h = Integer.parseInt(st.nextToken());   // 상자 수
        tomato = new int[h][n][m]; // 3차원 배열
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i < h; i++) {
            for (int j=0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0; k < m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) { // 익은 토마토
                        queue.add(new int[] {i, j, k});
                    }
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
                int z = now[0];
                int x = now[1];
                int y = now[2];
                for (int j=0; j < 6; j++) {
                    int nz = z + dz[j];
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    // 범위 안에 있는 칸이고 토마토가 익지 않은 경우
                    if (nz >= 0 && nz < h && nx >= 0 && nx < n && ny >= 0 && ny < m && tomato[nz][nx][ny] == 0) {
                        tomato[nz][nx][ny] = 1; // 익힌 토마토
                        queue.add(new int[] {nz, nx, ny});  // 익힌 토마토 큐에 저장
                    }
                }
            }
            if (!queue.isEmpty()) { // 큐가 비어있지 않으면 일수 추가
                days++;
            }
        }
        for (int i=0; i<h; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<m; k++) {
                    if (tomato[i][j][k] == 0) {
                        return -1; // 익지 않은 토마토가 있으면 -1 반환
                    }
                }
            }
        }
        return days;
    }
}
