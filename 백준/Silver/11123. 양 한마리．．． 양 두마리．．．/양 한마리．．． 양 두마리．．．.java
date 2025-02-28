import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int h, w;
    static char[][] sheeps;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {   // # == 양
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());   // 그리드의 높이
            w = Integer.parseInt(st.nextToken());   // 그리드의 너비
            sheeps = new char[h][w];
            for (int j = 0; j < h; j++) {
                String line = br.readLine();
                for (int k = 0; k < w; k++) {
                    sheeps[j][k] = line.charAt(k);
                }
            }
            int cnt = 0;
            visited = new boolean[h][w];
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (sheeps[j][k] == '#' && !visited[j][k]) {
                        dfs(j, k);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx >= 0 && ny >= 0 && nx < h && ny < w && sheeps[nx][ny] == '#' && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
