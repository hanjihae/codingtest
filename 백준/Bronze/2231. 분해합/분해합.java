import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;    // 생성자가 없는 경우 0 출력
        for (int i = 1; i < n; i++) { // n의 생성자 찾기
            int num = i;
            int sum = 0;
            while (num != 0) {  // i의 각 자릿수의 합 구하기
                sum += num % 10;
                num /= 10;
            }
            if (i + sum == n) { // i + i의 각 자릿수의 합 == n일 때 n의 생성자는 i
                ans = i;
                break;  // 1부터 시작했으므로 조건에 맞는 수가 있다면 그 수가 가장 작은 생성자
            }
        }
        System.out.println(ans);
    }
}