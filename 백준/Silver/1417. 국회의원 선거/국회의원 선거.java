import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 후보수
        int dasom = Integer.parseInt(br.readLine());    // 다솜 초기 투표 수
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    // 우선순위 큐 - 가장 큰 값이 먼저 오도록
        for (int i = 0; i < n-1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        while(!pq.isEmpty() && pq.peek() >= dasom) {    // pq가 비어있지 않은 상태 + pq의 가장 큰 값이 다솜이보다 클 때
            dasom++;    // 다솜 투표 수 + 1
            pq.add(pq.poll()-1); // pq 최댓값 - 1
            cnt++;  // 다른 후보의 투표자 매수한 횟수 카운트
        }
        System.out.println(cnt);
    }
}