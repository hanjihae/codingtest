import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] graph = new int[100001];   // 각 위치까지의 이동 횟수를 저장
    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);   // 시작 위치를 큐에 저장
        graph[n] = 1;   // 시작 위치 방문 표시
        while(!queue.isEmpty()) {
            int now = queue.poll(); // 큐에서 현재 위치 꺼냄
            for (int i=0; i < 3; i++) { // +1, -1, *2 세가지 이동 검사
                int next;
                if (i==0) {
                    next = now + 1;
                } else if (i==1) {
                    next = now - 1;
                } else {
                    next = now*2;
                }
                if (next == k) {    // 동생의 위치와 같을 때
                    System.out.println(graph[now]); // 현재 위치까지의 이동 횟수 출력
                    return;
                }
                // 이동할 위치가 범위 안에 있고, 아직 방문하지 않은 위치일 때
                if (next >= 0 && next < graph.length && graph[next] == 0) {
                    queue.add(next);    // 큐에 추가
                    graph[next] = graph[now] + 1;   // 이동 횟수 기록
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //  수빈이가 있는 위치
        k = Integer.parseInt(st.nextToken());   //  동생이 있는 위치
        if (n == k) {   // 수빈이와 동생의 위치가 같다면 0 출력
            System.out.println(0);
        } else {
            bfs(n);
        }
    }
}