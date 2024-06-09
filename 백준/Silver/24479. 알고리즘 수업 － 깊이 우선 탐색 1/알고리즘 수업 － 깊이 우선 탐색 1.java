import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int cnt; // 방문한 정점
    static int[] visited;   // 각 정점의 방문 순서를 저장하는 배열
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 정점의 수와 간선의 수, 시작 정점을 읽음
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken()); // 정점의 수
        int edge = Integer.parseInt(st.nextToken());   // 간선의 수
        int start = Integer.parseInt(st.nextToken());  // 시작 정점

        // 그래프와 방문 여부 배열 초기화
        visited = new int[vertex+1];
        // 정점의 수만큼 그래프 리스트 초기화
        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 간선 정보를 읽어 그래프에 추가
        for (int i = 0; i < edge; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st1.nextToken());
            int y = Integer.parseInt(st1.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        // 각 정점의 인접 리스트를 오름차순으로 정렬
        for (int i = 1; i <= vertex; i++) {
            Collections.sort(graph.get(i));
        }
        // dfs 방문 순서 카운트 초기화
        cnt = 1;
        dfs(start);
        for (int i=1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void dfs(int start) {
        visited[start] = cnt;   // 현재 정점의 방문 순서 저장
        for (int i=0; i < graph.get(start).size(); i++) {
            int newNode = graph.get(start).get(i);  // 인접 정점
            if (visited[newNode] == 0) {    // 아직 방문하지 않았다면
                cnt++;  // 방문 순서 증가
                dfs(newNode);   // 인접 정점에 대해 재귀적으로 dfs 수행
            }
        }
    }
}