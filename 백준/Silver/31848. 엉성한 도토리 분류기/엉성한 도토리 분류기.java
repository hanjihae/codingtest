import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n개의 구멍, i번 구멍의 크기는 ai
// 도토리가 하나의 구멍을 지나고 나면 도토리 크기 -1씩 감소
// 도토리는 현재 크기보다 크거나 같은 구멍 지날 때 낙하
// 각 도토리를 분류기에 넣었을 때 낙하한 구멍 번호 순서대로 출력
public class Main {
    static int n, q;
    static int[] holeSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int prevHoleSize = 0;
        holeSize = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i <= n; i++) {
            // 구멍을 지날 때마다 도토리 크기가 1씩 감소하므로 도토리 크기를 1씩 줄여 추적하는 게 아니라
            // 구멍 크기에 1을 더하는 방식으로 구멍크기배열 저장
            // 그래서 i - 1 더하는 것
            int curHoleSize = Integer.parseInt(st.nextToken()) + (i - 1);
            // 이전 구멍의 최대 크기를 저장하는 건 이전에 지나갔던 구멍에서의 도토리 크기 변화가
            // 다음 구멍을 지나갈 때 영향을 미치지 않도록 하기 위함
            prevHoleSize = Math.max(prevHoleSize, curHoleSize);
            holeSize[i] = prevHoleSize;
        }
        q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < q; i++) {
            int dotori = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(dotori)).append(" ");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int dotori) {
        int left = 1;
        int right = n + 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if (dotori <= holeSize[mid]) {  // 구멍 크기가 도토리보다 크거나 같다면
                right = mid;    // 더 작은 값 탐색
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
