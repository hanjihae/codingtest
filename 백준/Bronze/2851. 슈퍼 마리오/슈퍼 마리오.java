import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        int sum = 0;    // 누적합
        int max = 0;    // 100에 가장 가까운 점수
        for (int i = 0; i < 10; i++) {
            sum += nums[i];
            // 현재 누적합이 100에 더 가깝다면
            if (Math.abs(100-sum) <= Math.abs(100-max)) {
                max = sum;  // max에 현재 누적합을 저장
            }
        }
        System.out.println(max);
    }
}