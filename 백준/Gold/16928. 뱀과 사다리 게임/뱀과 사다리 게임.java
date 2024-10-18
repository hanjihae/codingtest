import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[101];
        visited = new boolean[101];
        for (int i=1; i <= 100; i++) {
            arr[i] = i;
        }
        for(int i=0; i < n; i++) {  // 사다리
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x] = y;  // x < y 사다리를 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 큼
        }
        for(int i=0; i < m; i++) {  // 뱀
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u] = v;  // u > v 뱀을 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 작음
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 0});    // 1번칸에서 시작
        visited[1] = true;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int position = now[0];  // 위치
            int cnt = now[1];   // 주사위 굴리는 횟수
            if(position == 100) {   // 100번칸에 도달하면 횟수 리턴
                return cnt;
            }
            for(int i=1; i <= 6; i++) { // 주사위 돌리기
                int next = position + i;
                if(next > 100) continue;    // 주사위 굴린 결과가 100 이상일시 제외
                next = arr[next];
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[] {next, cnt + 1});
                }
            }
        }
        return -1;
    }
}
