import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i=0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a -> b일 때 b는 a를 해킹할 수 있다.
            list.get(b).add(a);
        }
        cnt = new int[n + 1];   // 해킹할 수 있는 컴퓨터 수 저장할 배열
        int max = 0;
        for (int i=1; i <= n; i++) {
            
            bfs(i);
            max = Math.max(max, cnt[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=1; i <= n; i++) {
            if (cnt[i] == max) {    // 해킹 컴퓨터 수 최댓값과 값이 같다면 해당 인덱스 저장
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n + 1];
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            // 신뢰관계가 있고 아직 방문하지 않은 경우
            for (int next : list.get(node)) {
                if (!visited[next]) {
                    cnt[start]++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
