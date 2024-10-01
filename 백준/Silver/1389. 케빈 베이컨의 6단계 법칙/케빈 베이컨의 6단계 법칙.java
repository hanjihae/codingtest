import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] friends;
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        friends = new int[n + 1][n + 1];
        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a][b] = 1;
            friends[b][a] = 1;
        }
        int min = Integer.MAX_VALUE;
        int person = 1;
        for (int i=1; i <= n; i++) {
            int sum = bfs(i);
            if (sum < min) {
                min = sum;
                person = i;
            }
        }
        System.out.println(person);
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1]; // 방문 여부
        int[] distance = new int[n + 1];    // 거리 저장
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int p = queue.poll();
            for(int i=1; i <= n; i++) {
                if (friends[p][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    distance[i] = distance[p] + 1;
                }
            }
        }
        int sum = 0;
        for (int i=1; i <= n; i++) {
            sum += distance[i];
        }
        return sum;
    }
}
