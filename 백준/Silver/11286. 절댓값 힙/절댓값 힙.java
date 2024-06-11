import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override   // 절댓값 크기별 오름차순 정렬, 절댓값 같을 경우 원래 값이 작은 순으로 정렬
            public int compare (Integer a, Integer b) {
                int x = Math.abs(a);
                int y = Math.abs(b);
                if (x > y) {    // 절댓값이 큰 경우 우선순위 낮음
                    return x-y;
                } else if (x == y) {    // 절댓값이 같은 경우 작은 게 우선순위 높음
                    if (a > b) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {    // 절댓값이 작은 경우 우선순위 높음
                    return -1;
                }
            }
        });
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) { // 숫자가 0이 아닌 경우 우선순위 큐에 추가
                pq.offer(num);
            } else {
                if (!pq.isEmpty()) {    // 숫자가 0인 경우 우선순위 큐에서 최솟값 출력
                    sb.append(pq.poll()).append("\n");
                } else {    // 우선순위 큐가 비어있는 경우 0 출력
                    sb.append("0\n");
                }
            }
        }
        System.out.println(sb);
    }
}