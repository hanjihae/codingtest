import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>(); // 가장 작은 수부터 poll되는 큐 (선입선출)
            for (int j = 0; j < k; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            // 두 개의 수 먼저 꺼내 더한 값을 누적합에 더하고 큐에 넣어 마지막에 누적합에 같이 더함
            while (pq.size() > 1) { // 최소 두개의 파일이 있어야 작업을 계속할 수 있으므로 pq.size() > 1
                long a = pq.poll(); // 큐에서 가장 작은 파일
                long b = pq.poll(); // 두번째로 작은 파일
                sum += a+b; // 두 파일 합치는 비용 누적합에 더함
                pq.add(a+b);    // 두 파일 합친 비용 다시 큐에 추가
            }
            System.out.println(sum);
        }
    }
}