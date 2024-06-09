import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertex = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        int[][] graph = new int[vertex+1][vertex+1];
        boolean[] visited = new boolean[vertex+1];
        for(int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        dfs(graph, visited, 1);
        int ans = 0;
        for(int i=0; i < visited.length; i++) {
            if(visited[i]) {
                if (i == 1) continue;   // 1번 컴퓨터 제외
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int[][] graph, boolean[] visited, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        while(!stack.isEmpty()) {
            int vertex = stack.pop();
            for (int i=1; i < graph.length; i++) {
                // 인접행렬을 봤을 때 연결된 정점인지
                // 방문 리스트를 봤을 때 방문한 적 없는 정점인지
                if (graph[vertex][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
    }
}