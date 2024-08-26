import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());   // k <= n
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long max = Long.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }
        long start = 1;
        long end = max;
        while(start <= end) {
            long mid = (start + end) / 2;
            int cnt = 0;    // mid 길이로 자른 랜선 개수
            for (int i=0; i < k; i++) {
                cnt += arr[i]/mid;
            }
            if (cnt >= n) {
                // mid 길이로 n개 이상의 랜선을 만들 수 있다면 더 긴 랜선 길이를 찾기 위해
                start = mid + 1;
            } else {    // mid 길이로 n개 이상 랜선을 만들 수 없을 때
                end = mid - 1;
            }
        }
        // cnt >= n을 만족하는 가장 긴 랜선 길이
        System.out.println(end);
    }
}
