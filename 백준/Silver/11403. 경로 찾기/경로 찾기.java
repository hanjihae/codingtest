import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++) { // 방향그래프
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = new int[n][n];
        for (int i=0; i < n; i++) {
            bfs(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(start);
        // 예를 들어 1->2->3->1 경로일 때 자기자신과 경로도 양수이다 == 간접경로 포함
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int i=0; i < n; i++) {
                if (arr[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    ans[start][i] = 1;  // 시작 정점에서 해당 정점으로의 경로를 결과 배열에 표시
                }
            }
        }
    }
}
