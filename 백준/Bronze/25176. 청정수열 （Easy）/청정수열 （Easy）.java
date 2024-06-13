import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 청정수열 = (두 개의 i 사이 있는 수의 합)*i 을 최소화하려면 두 개의 i 사이에 수가 최대한 없어야 함.
        // 11, 22, 33 붙어있는 두 개의 수를 하나로 치면 1, 2, 3.. 순열의 개수와 동일함.
        // 그러므로 순열 N!와 같음. N! = 1*2*...*N
        long num = 1;
        for (int i = 1; i <= N; i++) {
            num *= i;
        }
        System.out.println(num);
    }
}
