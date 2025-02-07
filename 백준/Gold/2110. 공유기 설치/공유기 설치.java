import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수직선 위에 도현이 집 n개, 공유기 c개
// 하나 이상의 빈 집을 사이에 두고 집 하나당 공유기 하나
// 가장 인접한 두 공유기 거리 최댓값 출력
public class Main {
    static int n, c;
    static int[] x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 집 수
        c = Integer.parseInt(st.nextToken());   // 공유기 수
        x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(x);
        int low = 1;
        int high = x[n - 1] - x[0];
        int ans = 0;
        while(low <= high) {
            int mid = (low + high) / 2; // 공유기 간 거리
            if (canInstall(mid)) {
                ans = mid;
                low = mid + 1;  // 더 넓은 거리 탐색
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean canInstall(int mid) {
        int cnt = 1;    // 첫번째 집에 공유기 설치
        int lastInstalled = x[0];
        for (int i = 1; i < n; i++) {
            // 현재 집과 마지막으로 설치된 집 간의 거리가 mid보다 크거나 같다면
            if (x[i] - lastInstalled >= mid) {
                cnt++;  // 공유기 수 카운트
                lastInstalled = x[i];
            }
        }
        return cnt >= c;    // c개 이상 설치 가능하면 true
    }
}
