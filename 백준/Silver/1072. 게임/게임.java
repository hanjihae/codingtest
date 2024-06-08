import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x, y;
        x = Integer.parseInt(st.nextToken());   // 게임 횟수
        y = Integer.parseInt(st.nextToken());   // x 번의 게임 중 y번 이김
        int originalZ = (int) (y* 100/ x);  // 원래 승률
        if (originalZ >= 99) {  // 원래 승률이 99이상이면 승률을 올릴 수 없으므로
            System.out.println(-1); // -1 출력
            return;
        }
        int start = 0;
        int end = 1000000000;
        int ans = -1;   // 조건을 만족하는 mid 값이 없는 경우를 상정해 초기값 -1
        while (start <= end) {  // start > end일 때 mid = 추가 게임 횟수의 최솟값
            int mid = (start + end)/2;  // 추가 게임 횟수
            int newZ = (int) (((y + mid)* 100) / (x + mid));    // 새로운 승률
            if (newZ > originalZ) {
                ans = mid;  // 현재 mid 값이 유효한 최솟값일 가능성 있음
                end = mid - 1;  // 최솟값을 찾기 위해 더 작은 값 탐색
            } else {
                start = mid + 1;    // 승률이 증가하지 않았으므로 더 큰 값 탐색
            }
        }
        System.out.println(ans);
    }
}