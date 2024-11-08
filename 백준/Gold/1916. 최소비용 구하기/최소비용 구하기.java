import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements  Comparable<Node> {
    int city;
    int cost;
    Node(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}

public class Main {
    static int n, m;    // 도시 개수, 버스 개수
    static ArrayList<ArrayList<Node>> list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());    // 도시 개수
        m = Integer.parseInt(br.readLine());    // 버스 개수
        // 출발 도시 번호, 도착 도시 번호, 버스 비용
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>()); // 각 도시에 대한 리스트 초기화
        }
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        StringTokenizer st;
        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, cost));
        }
        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        System.out.println(Dijkstra(startCity, endCity));
    }

    public static int Dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        pq.add(new Node(start, 0)); // 시작 도시, 비용 0으로 시작
        dist[start]= 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.city; // 도착 도시
            if (!visited[now]) {    // 해당 도시를 방문하지 않았다면
                visited[now] = true;    // 방문 표시
                for (Node node : list.get(now)) {   // 해당 도시가 출발지인 리스트 뽑아와서
                    // 도착지 방문 안되어 있고, 도착지 비용 > 현재 출발지 비용 + 여기서 도착지 가는 비용이라면
                    if (!visited[node.city] && dist[node.city] > dist[now] + node.cost) {
                        // 해당 도착지까지의 비용 = 현재 출발지 비용 + 출발지 > 도착지 가는 비용
                        dist[node.city] = dist[now] + node.cost;
                        pq.add(new Node(node.city, dist[node.city]));
                    }
                }
            }
        }
        return dist[end];   // 목표 도착지 비용 리턴
    }
}
