import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());   // 정점 수
        n = Integer.parseInt(st.nextToken());   // 간선 수
        int v = Integer.parseInt(st.nextToken());
        arr = new int[m + 1][m + 1];    // 그래프
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;  // 양방향 간선이므로 양쪽 모두 1로 설정
            arr[y][x] = 1;
        }
        visited = new boolean[m + 1];   // 방문 배열
        dfs(v);
        // dfs와 bfs 결과 구분을 위해 줄바꿈
        sb.append("\n");
        // bfs 실행하기 위해 방문 배열 초기화
        visited = new boolean[m + 1];
        bfs(v);
        System.out.println(sb);
    }

    public static void dfs(int v) {
        // 현재 정점 방문 처리
        visited[v] = true;
        // 방문한 정점 결과에 추가
        sb.append(v).append(" ");
        for(int i=1; i <= m; i++) { // 인접한 정점에 대해 dfs 실행
            // 연결되어 있고 방문하지 않은 경우 dfs 실행
            if (arr[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);   // 시작 정점을 큐에 추가
        visited[v] = true;  // 현재 정점 방문 처리
        while(!queue.isEmpty()) {
            int cur = queue.poll();   // 큐에서 정점 꺼내어 처리
            sb.append(cur).append(" ");   // 결과에 추가
            for (int i=1; i <= m; i++) {    // 인접한 정점에 대해 bfs 실행
                // 연결되어 있고 방문하지 않은 경우 bfs 실행
                if (arr[cur][i] == 1 && !visited[i]) {
                    queue.add(i);   // 인접한 정점 큐에 추가
                    visited[i] = true;  // 방문 처리
                }
            }
        }
    }
}
