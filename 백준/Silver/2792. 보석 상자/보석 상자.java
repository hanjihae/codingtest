import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 못 받은 학생 있어도 됨
// 학생은 항상 같은 색상의 보석만을 가짐
// 각 학생이 가장 적게 받을 수 있는 최대 보석 개수 == 질투심
public class Main {
    static int n, m;
    static int[] jewels;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 애들 수
        m = Integer.parseInt(st.nextToken());   // 색상 수
        jewels = new int[m];
        int max = 0;
        for (int i=0; i < m; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, jewels[i]);
        }
        System.out.println(binarySearch(max));;
    }

    public static int binarySearch(int max) {
        int start = 1;
        int end = max;
        int ans = end;
        while(start <= end) {
            int mid = (start + end) / 2;
            // mid개씩 보석을 나눠줄 수 있는 학생 수가 n보다 작거나 같다면
            if (canShareFairly(mid)) {
                ans = mid;  // 질투심 최솟값 갱신
                end = mid - 1;  // 더 작은 값 탐색
            } else {
                start = mid + 1;    // 더 큰 값 탐색
            }
        }
        return ans;
    }

    public static boolean canShareFairly(int mid) {
        int students = 0;
        for (int jewel : jewels) {
            students += (jewel + mid - 1) / mid;    // 올림 계산
        }
        return students <= n;
    }
}
