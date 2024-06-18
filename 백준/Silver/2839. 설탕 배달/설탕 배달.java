import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int bongji = 0;
        while(n > 0) {
            if (n % 5 == 0) {   // 5kg짜리로 커버되면
                bongji += n/5;
                break;
            } else {   // 아닐 경우 3kg거나 나눠 담지 못하는 경우
                n -= 3;
                bongji++;
            }
            if (n < 0) {    // n킬로그램으로 만들 수 없는 경우 -1 출력
                bongji = -1;
            }
        }
        System.out.println(bongji);
    }
}