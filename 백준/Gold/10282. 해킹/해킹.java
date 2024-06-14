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
        return this.cost - o.cost;
    }
}

public class Main {
    static int n, d, c;
    static ArrayList<Node>[] graph;
    static int cnt;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   // 컴퓨터 개수 == 정점 수
            d = Integer.parseInt(st.nextToken());   // 의존성 개수 == 간선 수
            c = Integer.parseInt(st.nextToken());   // 해킹당한 컴퓨터 번호
            graph = new ArrayList[n+1];
            for (int j = 0; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }
            for(int j=0; j<d; j++) {
                StringTokenizer com = new StringTokenizer(br.readLine());
                // a가 b를 의존하며, b가 감염되면 s초 후 a도 감염됨
                int a = Integer.parseInt(com.nextToken());
                int b = Integer.parseInt(com.nextToken());
                int s = Integer.parseInt(com.nextToken());
                // b가 감염되면 s초 후 a도 감염되므로 b->a 간선 추가
                graph[b].add(new Node(a, s));
            }
            cnt = 0;    // 감염된 컴퓨터 수
            dist = new int[n+1];    // 거리 배열
            visited = new boolean[n+1]; // 방문 배열
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[c] = 0;
            Dijkstra();
            int time = 0;
            for (int j=1; j<=n; j++) {
                if (dist[j] != Integer.MAX_VALUE) { // 감염된 컴퓨터라면
                    time = Math.max(time, dist[j]); // 감염되기 까지 걸린 시간
                }
            }
            System.out.println(cnt + " " + time);
        }
    }

    public static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(c, 0));   // 해킹당한 컴퓨터 큐에 추가
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!visited[cur.index]) {  // 방문하지 않았다면
                visited[cur.index] = true;  // 방문 표시
                cnt++;  // 감염된 컴퓨터 수 증가
            } else continue;    // 이미 방문했다면 건너뛰기
            for (int j=0; j<graph[cur.index].size(); j++) {
                Node next = graph[cur.index].get(j);    // 현재 노드의 인접 노드
                // 현재 노드를 거쳐 가는 게 더 짧다면
                if (dist[next.index] > dist[cur.index] + next.cost) {
                    dist[next.index] = dist[cur.index] + next.cost; // 거리 갱신
                    pq.offer(new Node(next.index, dist[next.index]));   // 갱신된 노드 큐에 추가
                }
            }
        }
    }
}