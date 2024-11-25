import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, s, e;
    static ArrayList<Integer>[] teleports;
    static int[] time;
    static int[] dir = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 정거장 수
        m = Integer.parseInt(st.nextToken());   // 텔레포트 수
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());   // 출발지
        e = Integer.parseInt(st.nextToken());   // 목적지
        
        teleports = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            teleports[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            teleports[x].add(y);
            teleports[y].add(x);
        }
        
        time = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            time[i] = Integer.MAX_VALUE; // 초기값을 매우 큰 값으로 설정
        }
        
        bfs();
        System.out.println(time[e]);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        time[s] = 0; // 시작 지점의 시간 0으로 설정

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 앞뒤로 이동
            for (int d : dir) {
                int next = cur + d;
                if (next > 0 && next <= n && time[next] > time[cur] + 1) {
                    time[next] = time[cur] + 1;
                    queue.add(next);
                }
            }

            // 텔레포트 이동
            for (int next : teleports[cur]) {
                if (time[next] > time[cur] + 1) {
                    time[next] = time[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
