import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 나무의 수
        int M = Integer.parseInt(st.nextToken());   // 집으로 가져가려는 나무의 길이
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] tree = new int[N];
        int start = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {   // 각 나무 높이 저장
            tree[i] = Integer.parseInt(st1.nextToken());
            end = Math.max(end, tree[i]);   // 가장 높은 나무의 높이 저장
        }
        while (start <= end) {
            int mid = (start+end)/2;
            long tl = 0;    // 가져갈 수 있는 나무의 길이
            for (int i = 0; i < N; i++) {   // 나무 개수만큼 반복
                if (tree[i] > mid) {    // 나무의 길이가 mid 보다 큰 경우 잘림
                    tl += tree[i] - mid;
                }
            }
            if (tl >= M) {  // 가져갈 수 있는 길이가 목표보다 크거나 같으면
                start = mid + 1;    // 시작 범위를 더 큰 높이 탐색
            } else if (tl < M) {    // 가져갈 수 있는 길이가 목표보다 작으면
                end = mid - 1;  // 끝 범위를 더 작은 높이 탐색
            }
        }
        System.out.println(end);    // 최대 길이 출력
    }
}