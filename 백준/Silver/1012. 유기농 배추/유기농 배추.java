import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m, n, k;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};    // 상하
    static int[] dy = {0, 0, -1, 1};    // 좌우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());   // 배추밭 가로
            n = Integer.parseInt(st.nextToken());   // 배추밭 세로
            k = Integer.parseInt(st.nextToken());   // 배추 위치
            arr = new int[m][n];
            visited = new boolean[m][n];
            for (int j=0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            int cnt = 0;    // 필요한 배추흰지렁이 수
            for (int a=0; a < m; a++) {
                for (int b=0; b < n; b++) {
                    // 배추가 심어져 있고 방문하지 않은 경우
                    if (arr[a][b] == 1 && !visited[a][b]) {
                        dfs(a, b);  // 인접한 영역 모두 방문처리
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;   // 방문 처리
        // 상하좌우 이동하며 연결된 영역 찾기
        for (int i=0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            // 새로운 좌표가 배추밭 내에 있고
            if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                // 배추가 심어져 있고 방문하지 않은 경우
                if (arr[newX][newY] == 1 && !visited[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }
    }
}
