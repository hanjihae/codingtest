import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, k;
    public static int[] arr = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
        } else {
            bfs(n);
        }
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        arr[n] = 1;
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for (int i=0; i < 3; i++) {
                int next;
                if (i == 0) {   // 세가지 이동 검사
                    next = x - 1;
                } else if (i == 1) {
                    next = x + 1;
                } else {
                    next = x * 2;
                }
                if (next == k) {
                    System.out.println(arr[x]);
                    return;
                }
                // 범위 안이고 방문하지 않은 위치일 때
                if (next >= 0 && next < arr.length && arr[next] == 0) {
                    queue.add(next);
                    arr[next] = arr[x] + 1; // 이동 횟수 기록
                }
            }
        }
    }
}
