import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] store = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            store[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;    // 마실 수 있는 우유 수
        int cur = 0;    // 순서에 맞는 우유
        for (int i = 0; i < n; i++) {
            if (store[i] == cur) {
                cnt++; // i번째 우유가 마셔도 되는 우유라면 카운트
                cur = (cur + 1) % 3;    // 우유 0, 1, 2 순서
            }
        }
        System.out.println(cnt);
    }
}