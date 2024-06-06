import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {   // x가 0이라면 배열에서 가장 작은 값 출력
                if (minHeap.isEmpty()) {    // 배열이 비어 있는 경우 0 출력
                    System.out.println("0");
                } else {
                    System.out.println(minHeap.poll());
                }
            } else {    // x가 자연수라면 배열에 추가
                minHeap.add(x);
            }
        }
    }
}