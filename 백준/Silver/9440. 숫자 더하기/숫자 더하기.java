import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int[] nums = new int[n];
            int zeroCnt = 0;    // 0 개수
            for (int i=0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
                if (nums[i] == 0) { // 0인 경우 카운트
                    zeroCnt++;
                }
            }
            Arrays.sort(nums);  // 오름차순 정렬
            for (int i=0; i< 2; i++) {  // 가장 작은 수 두 개가 0이 아닌 수로 시작되도록 0과 교환
                if (nums[i] == 0) { // 베열의 처음에 0이 있으면
                    int temp = nums[i];
                    nums[i] = nums[zeroCnt + i];    // 0 이후 가장 작은 수와 교환
                    nums[zeroCnt + i] = temp;
                }
            }
            int num1 = 0;
            int num2 = 0;
            int idx1 = (n - 1) / 2;  // num1의 시작 자릿수
            int idx2 = (n / 2) - 1;    // num2의 시작 자릿수

            // 숫자를 두 그룹으로 나누어 합 계산
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    num1 += nums[i] * Math.pow(10, idx1--);
                } else {
                    num2 += nums[i] * Math.pow(10, idx2--);
                }
            }
            sb.append(num1 + num2).append("\n");
        }
        System.out.println(sb);
    }
}
