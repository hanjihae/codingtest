import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minus = br.readLine().split("-");
        long ans = 0;
        for (int i=0; i < minus.length; i++) {
            // - () 괄호 안 수들 더하기
            String[] parts = minus[i].split("\\+");
            int[] nums = new int[parts.length];
            for(int j=0; j < nums.length; j++) {
                nums[j] = Integer.parseInt(parts[j]);
            }
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (i == 0) { // 첫번째 수는 양수
                ans += sum;
            } else {
                ans -= sum;
            }
        }
        System.out.println(ans);
    }
}
