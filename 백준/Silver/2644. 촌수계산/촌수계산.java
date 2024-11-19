import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int a, b;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        int ans = bfs();
        System.out.println(ans);
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, 0});    // 시작, 촌수
        visited[a] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int now = cur[0];
            int depth = cur[1];
            if (now == b) {
                return depth;
            }
            for (int i=1; i <= n; i++) {
                if (arr[now][i] == 1 && !visited[i]) {
                    queue.add(new int[] {i, depth + 1});
                    visited[i] = true;
                }
            }
        }
        return -1;  // 촌수 못 찾은 경우 -1 리턴
    }
}