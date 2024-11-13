import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int[] arr = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arrays.fill(arr, -1);
        if (n == k) {
            System.out.println(0);
        } else {
            bfs();
        }
    }

    public static void bfs() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(n);
        arr[n] = 0;
        while (!deque.isEmpty()) {
            int x = deque.poll();
            int[] directions = {x - 1, x + 1, x * 2};
            for (int next : directions) {
                if (next >= 0 && next <= 100000 && arr[next] == -1) {
                    if (next == x * 2) {    // 순간이동일 때
                        arr[next] = arr[x]; // 0초
                        deque.addFirst(next);   // 순간이동 우선처리
                    } else {
                        arr[next] = arr[x] + 1;
                        deque.addLast(next);
                    }
                    if (next == k) {
                        System.out.println(arr[next]);
                        return;
                    }
                }
            }
        }
    }
}