import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] list;
    static int[] parent;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for(int i=1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        dfs(1); // 1번 노드를 루트로 설정하고 dfs 시작
        for(int i=2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int node) {
        visited[node] = true;
        for(int next : list[node]) {
            if(!visited[next]) {
                parent[next] = node;    // 현재 노드를 부모로 저장
                dfs(next);
            }
        }
    }
}
