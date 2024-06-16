import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5]; // 다섯 개의 자연수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int multi = 1;  // 배수, 0은 못 나누므로 1부터 시작
        int cnt = 0;    // 몇 개의 배수가 되는지 저장
        while (true) {
            for (int i=0; i < arr.length; i++) {
                // 배수를 해당 자연수로 나누고 난 나머지가 0일 때 카운트
                if (multi % arr[i] == 0) {
                    cnt++;
                }
            }
            if (cnt >= 3) { // 만약 세 개 이상의 자연수의 배수라면
                System.out.println(multi);  // 해당 배수 출력
                return; // 종료
            }
            cnt = 0;    // cnt < 3 이라면 cnt 리셋
            multi++;    // 배수 1씩 올려서 탐색
        }
    }
}