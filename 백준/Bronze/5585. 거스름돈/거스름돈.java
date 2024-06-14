import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = 1000 - Integer.parseInt(br.readLine());
        int[] extra = {500, 100, 50, 10, 5, 1}; // 잔돈
        int cnt = 0;    // 잔돈 개수
        for (int i = 0; i < extra.length; i++) {
            if (change < extra[i]) continue;    // 현재 동전이 거스름돈보다 크다면 패스
            cnt += change/extra[i]; // 거스름돈을 현재 동전으로 줄 수 있는 개수 저장
            change %= extra[i]; // 거스름돈을 현재 동전으로 주고 난 나머지를 갱신
        }
        System.out.println(cnt);
    }
}