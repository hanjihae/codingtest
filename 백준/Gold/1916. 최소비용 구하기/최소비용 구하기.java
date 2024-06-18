import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int node;
    int cost;
    Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        }
        StringTokenizer se = new StringTokenizer(br.readLine());
        int startPos = Integer.parseInt(se.nextToken());
        int endPos = Integer.parseInt(se.nextToken());
        System.out.println(Dijkstra(startPos, endPos));
    }

    public static int Dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.node;
            if (!visited[now]) {
                visited[now] = true;
                for (Node node : graph.get(now)) {
                    if (!visited[node.node] && dist[node.node] > dist[now] + node.cost) {
                        dist[node.node] = dist[now] + node.cost;
                        pq.add(new Node(node.node, dist[node.node]));
                    }
                }
            }
        }
        return dist[end];
    }
}