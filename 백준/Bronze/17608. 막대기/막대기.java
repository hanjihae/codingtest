import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] makdaegi = new int[N];
        for (int i = 0; i < N; i++) {
            makdaegi[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 1;    // 오른쪽에서 보이는 개수
        int rightM = makdaegi[makdaegi.length - 1]; // 가장 오른쪽 막대기
        for (int i = makdaegi.length-2; i >= 0; i--) {
            if (makdaegi[i] > rightM) {
                cnt++;  // 오른쪽에서 보이는 막대기의 수 출력
                rightM = makdaegi[i];   // 높이가 맨오른쪽 막대기보다 높다면 높은 거로 변경
            }
        }
        System.out.println(cnt);
    }
}