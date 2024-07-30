import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//        i++에 6씩 추가되는 규칙
//        1 2(+1) 9(+7) 22(+13) 41(+19) 66(+25)
//        1 3(+2) 11(+8) 25(+14) 45(+20) 70(+26)
//        1 4(+3) 13(+9) 28(+15) 49(+21) ...

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 1;
        int cnt = 1;    // 방에 들리는 횟수
        for (int i = 1; sum < n; i++) { // 방의 값이 n보다 크면 반복문 종료
            cnt++;
            sum += i*6;
        }
        System.out.println(cnt);
    }
}