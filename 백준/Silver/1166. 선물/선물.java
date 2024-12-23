import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, l, w, h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 작은 정육면체 박스 N개
        // N개 박스 담을 큰 박스
        l = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        // 이분탐색
        double start = 0;   // 정육면체 한 변의 최소 크기
        double end = Math.min(Math.min(l, w), h);   // 가로, 세로, 높이 중 최솟값
        double mid;
        while(start < end) {
            mid = (start + end) / 2;
            // 현재 작은 박스 수
            long boxes = (long)(l/mid) * (long)(w/mid) * (long) (h/mid);
            if (boxes < n) {  // 작은 박스 수가 N개보다 적다면
                if (end == mid) break;
                end = mid;  // end 값을 줄여 더 작은 값 탐색
            } else {
                if (start == mid) break;
                start = mid;    // start 값을 올려 더 큰 값 탐색
            }
        }
        System.out.println(start);
    }
}
