import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;   // 방문 여부 체크
    static int[] result;    // 방문 순서 체크
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken()); // 정점의 수
        int edge = Integer.parseInt(st.nextToken());   // 간선의 수
        int start = Integer.parseInt(st.nextToken());  // 시작 정점
        result = new int[vertex+1];
        // 정점의 수만큼 그래프 리스트 초기화
        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
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
        bfs(start, vertex);
        for (int i=1; i <= vertex; i++) {
            System.out.println(result[i]);
        }
    }

    private static void bfs(int start, int vertex) {
        int cnt = 1;
        visited = new boolean[vertex+1];  // 정점 수만큼 방문 배열 초기화
        Queue<Integer> queue = new LinkedList<>();
        // 시작 정점을 큐에 넣고 방문 표시
        queue.add(start);
        visited[start] = true;  // 방문 표시
        result[start] = cnt++;  // 방문 순서 기록
        while (!queue.isEmpty()) {  // 큐가 비어 있지 않는 경우
            int nowNode = queue.poll(); // 큐에서 정점 꺼내기
            for (int num : graph.get(nowNode)) {    // 현재 정점의 모든 인접 정점
                if (!visited[num]) {    // 아직 방문하지 않은 정점이라면 visited[num] == false
                    queue.add(num); // 큐에 넣고
                    visited[num] = true;    // 방문 표시
                    result[num] = cnt++;    // 방문 순서 기록
                }
            }
        }
    }
}
