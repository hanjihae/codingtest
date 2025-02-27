import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우 == 인접하다
// 한 배추에 지렁이 있으면 인접한 배추들로 이동 가능
// 지렁이 몇 마리 필요한지

public class Main {
    static int m, n;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] field = new int[m][n];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }
            visited = new boolean[m][n];
            int cnt = 0;
            for (int a = 0; a < m; a++) {
                for (int b = 0; b < n; b++) {
                    if (field[a][b] == 1 && !visited[a][b]) {
                        dfs(a, b, field);
                        cnt++;
                    }   // 1인데 방문하지 않은 곳에서 인접까지 방문하고 와서 +1
                }
            }
            System.out.println(cnt);
        }
    }

    public static void dfs(int x, int y, int[][] field) {
        visited[x][y] = true;
        for (int i=0; i<4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && field[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny, field);
            }
        }
    }
}
