import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] nums;  // 숫자 저장
    static int[] ops;   // 연산자 저장
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void dfs(int num, int idx) {
        if (idx == n) { // 모든 숫자를 다 계산한 경우 최댓값, 최솟값 갱신
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {   // 해당 연산자가 남아 있는 경우
                ops[i]--;   // 연산자 사용
                switch(i) {
                    case 0: dfs(num + nums[idx], idx+1); break;
                    case 1: dfs(num - nums[idx], idx+1); break;
                    case 2: dfs(num * nums[idx], idx+1); break;
                    case 3: dfs(num / nums[idx], idx+1); break;
                }
                ops[i]++;   // 연산자 복원 - 백트래킹
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer num = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(num.nextToken());
        }
        ops = new int[4];  // +,-, x, /
        StringTokenizer op = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(op.nextToken());
        }
        dfs(nums[0], 1);    // 첫번째 수부터 dfs 시작
        System.out.println(max);
        System.out.println(min);
    }
}