import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i=0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            max = Math.max(cards[i], max);  // 최댓값
            if (max == cards[i]) {
                idx = i;    // 최댓값 인덱스
            }
        }
        int sum = 0;
        // 어쨌든 임시카드를 만들어도 max 레벨은 유지가 되므로 최댓값 기준 합을 구함
        for (int i=0; i < idx; i++) {   // 최댓값 기준 왼쪽 부분
            sum += cards[i] + max;
        }
        if (idx < n) {
           for (int i = idx + 1; i < n; i++) {  // 최댓값 기준 오른쪽 부분
               sum += cards[i] + max;
           }
        }
        System.out.println(sum);
    }
}
