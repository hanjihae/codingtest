import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }
        long start = 1;
        long end = max;
        while(start <= end) {
            long mid = (start+end)/2;
            long sum = 0;
            for (int i = 0; i < K; i++) {   // 잘라진 랜선 개수 합
                sum += arr[i]/mid;
            }
            // long sum = Arrays.stream(arr).map(e -> e / mid).sum();
            if (sum >= N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}