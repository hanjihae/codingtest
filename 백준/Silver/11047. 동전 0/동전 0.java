import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] money = new int[n];
        for (int i=0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        for (int i=n-1; i >= 0; i--) {   // 액수가 큰 동전부터
            if (money[i] > k) continue; // k보다 액수가 크면 패스
            ans += k / money[i];    // 현재 동전으로 채울 수 있는 값 ans에 저장
            k = k % money[i];   // 현재 동전으로 나누고 남은 수 k에 저장
        }
        System.out.println(ans);
    }
}
