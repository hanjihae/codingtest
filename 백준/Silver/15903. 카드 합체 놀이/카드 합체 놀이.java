import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// x, y 카드 골라 더한 값을 계산 , x != y
// 계산한 값은 both x, y 카드에 덮어쓰기
// 이런 카드 합체를 총 m번 반복 후 n장 카드의 합계의 최솟값 구하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Long> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }
        for (int i=0; i < m; i++) {
            long x = queue.poll();
            long y = queue.poll();
            long sum = x + y;
            queue.add(sum);
            queue.add(sum);
        }
        long ans = 0;
        while(!queue.isEmpty()){
            ans += queue.poll();
        }
        System.out.println(ans);
    }
}
