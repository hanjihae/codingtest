import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int index;
    int cost;
    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost); // 비용 기준으로 오름차순 정렬
    }
}

public class Main {
    static ArrayList<Node>[] graph;
    static int n;
    static int[] vv = new int[2];   // 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호
    static int[] dist;  // 최단거리를 저장하는 배열
    static int INF = 2000000000;    // 2000000*1000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 정점 수
        int e = Integer.parseInt(st.nextToken());   // 간선 수
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            StringTokenizer nodes = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(nodes.nextToken());
            int w = Integer.parseInt(nodes.nextToken());
            int cost = Integer.parseInt(nodes.nextToken());
            graph[v].add(new Node(w, cost));
            graph[w].add(new Node(v, cost));
        }
        StringTokenizer v = new StringTokenizer(br.readLine());
        vv[0] = Integer.parseInt(v.nextToken());    // v1
        vv[1] = Integer.parseInt(v.nextToken());    // v2

        dist = new int[n+1];
        // 1 -> v1 -> v2 -> n
        int ans1 = maxOrNot(1, vv[0], vv[1], n);
        // 1 -> v2 -> v1 -> n
        int ans2 = maxOrNot(1, vv[1], vv[0], n);

        if (ans1 >= INF && ans2 >= INF) {   // 두 경로 모두 INF 이상이면 도달 불가능
            System.out.println(-1);
        } else {
            System.out.println(Math.min(ans1, ans2));
        }
    }

    public static int maxOrNot(int start, int mid1, int mid2, int end) {
        int dist1 = Dijkstra(start, mid1);
        int dist2 = Dijkstra(mid1, mid2);
        int dist3 = Dijkstra(mid2, end);
        if (dist1 == INF || dist2 == INF || dist3 == INF) {
            return INF;
        }
        return dist1 + dist2 + dist3;
    }

    public static int Dijkstra(int start, int end) {
        boolean[] visited = new boolean[n+1];   // 정점은 1부터 시작, 방문여부 배열
        Arrays.fill(dist, INF); // 거리 배열 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));   // 시작노드 추가
        dist[start] = 0;    // 시작 노드의 거리 0으로 설정

        while (!pq.isEmpty()) {
            Node cur = pq.poll();   // 가장 비용이 적게 드는 노드 꺼내기
            if (visited[cur.index]) continue;   // 이미 방문한 노드면 건너뛰기
            visited[cur.index] = true;  // 현재 노드 방문 표시
            for (int i=0; i < graph[cur.index].size(); i++) {
                Node next = graph[cur.index].get(i);    // 인접 노드
                // 기존 노드보다 현재 노드를 통해 인접 노드로 가는 경로가 더 짧으면 갱신
                if (dist[next.index] > dist[cur.index] + next.cost) {
                    dist[next.index] = dist[cur.index] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));   // 갱신된 노드 큐에 추가
                }
            }
        }
        return dist[end];
    }


}