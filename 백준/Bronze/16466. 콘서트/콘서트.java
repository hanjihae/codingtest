import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] hcpc = new int[N];
        for (int i = 0; i < N; i++) {
            hcpc[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(hcpc);  // 팔린 티켓 사전순 정렬
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (hcpc[i] != i+1) {   // 팔린 티켓과 인덱스+1과 일치하지 않을 때
                System.out.println(i+1);    // 살 수 있는 티켓 중 최솟값 출력
                cnt++;
                break;  // 찾았으니 반복문 종료
            }
        }
        if (cnt == 0) System.out.println(N+1);  // 팔린 티켓이 모두 연속적인 경우 팔린 티켓 개수 + 1
    }
}