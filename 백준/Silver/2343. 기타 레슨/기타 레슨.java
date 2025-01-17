import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] blurays;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 강의 개수
        m = Integer.parseInt(st.nextToken());   // 블루레이 개수
        blurays= new int[n + 1];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int sum = 0;
        for (int i=0; i < n; i++) {
            blurays[i] = Integer.parseInt(st.nextToken());
            sum += blurays[i];
            max = Math.max(blurays[i], max);
        }
        System.out.println(binarySearch(max, sum));;
    }

    public static int binarySearch(int start, int end) {
        int ans = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int mid) {
        int sum = 0;
        int cnt = 1;    // 블루레이 개수 1개부터 카운트
        for (int i =0; i < n; i++) {
            if (sum + blurays[i] > mid) {   // 블루레이 크기 합계가 기준보다 클때 블루레이 개수 증가
                cnt++;
                sum = blurays[i];
            } else {
                sum += blurays[i];
            }
        }
        // 개수가 m보다 작거나 같으면 true, 개수가 m보다 크면 false 리턴
        return cnt <= m;
    }
}
